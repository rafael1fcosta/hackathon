package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ScreenManager;

public class GameOne extends ScreenAdapter {

    private ScreenManager screenManager;

    private GameObject player;
    private GameObject enemy;

    private Texture gameBackground;

    private Array<GameObject> books;

    private Array<Rectangle> collidables;


    public GameOne(ScreenManager screenManager) {
        this.screenManager = screenManager;
        create();
    }


    public void create() {

        player = new Player();
        enemy = new Enemy();

        books = new Array<>();
        collidables = new Array<>();

        createCollidables();

        gameBackground = new Texture(Gdx.files.internal("backgroundGameOne.jpg"));
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        setPlayerPosToEnemy();

        screenManager.getBatch().begin();
        screenManager.getBatch().draw(gameBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screenManager.getBatch().draw(player.getTexture(), player.getX(), player.getY());


        for (GameObject book : books) {
            book.render(screenManager.getBatch());
        }

        player.render(screenManager.getBatch());
        enemy.render(screenManager.getBatch());

        screenManager.getBatch().end();


        CollisionEngine.checkForBookPicked(player, books);


        if (Math.random() * 100 < 1) {
            createBook();
        }


    }

    @Override
    public void dispose() {
        player.getTexture().dispose();
        enemy.getTexture().dispose();
    }

    private void createBook() {
        Book book = new Book(MathUtils.random(0, 950), MathUtils.random(0, 700)); //TODO: limits!
        books.add(book);
    }

    private void createCollidables() {
        collidables.add(new Rectangle(155, 260, 55, 55));
        collidables.add(new Rectangle(121, 455, 195, 57));
        collidables.add(new Rectangle(468, 164, 50, 200));

        collidables.add(new Rectangle(692, 224, 45, 20));
        collidables.add(new Rectangle(748, 224, 120, 40));
        collidables.add(new Rectangle(875, 224, 25, 50));

        collidables.add(new Rectangle(840, 384, 25, 25));
        collidables.add(new Rectangle(827, 421, 60, 60));
        collidables.add(new Rectangle(878, 467, 25, 25));
        collidables.add(new Rectangle(570, 527, 94, 60));
        collidables.add(new Rectangle(600, 495, 25, 25));

        //walls
        collidables.add(new Rectangle(0, 0, 318, 105));
        collidables.add(new Rectangle(429,0, 595, 105));

        collidables.add(new Rectangle(0, 700, 290, 120));
        collidables.add(new Rectangle(477, 700, 536, 120));

        ((Player) player).addCollidables(collidables);
    }

    private void setPlayerPosToEnemy() {

        Enemy enemy1 = (Enemy) enemy;
        enemy1.setPlayerPosition(player.getX(), player.getY());
    }

}
