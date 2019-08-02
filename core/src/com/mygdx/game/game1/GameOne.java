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


    public void create(){

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



        screenManager.getBatch().begin();
        screenManager.getBatch().draw(gameBackground, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
    }

    private void createBook() {
        Book book = new Book(MathUtils.random(0, 950), MathUtils.random(0, 700)); //TODO: limits!
        books.add(book);
    }

    private void createCollidables() {
        collidables.add(new Rectangle(500,500, 100, 100));


        ((Player) player).addCollidables(collidables);
    }

}
