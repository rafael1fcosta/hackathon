package com.mygdx.game.game1;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ScreenManager;

public class GameOne extends ScreenAdapter {

    private boolean isGamePaused;

    private ScreenManager screenManager;

    private GameObject player;
    private GameObject enemy;

    private Texture gameBackground;
    private Texture gamePause;

    private Array<GameObject> books;

    public GameOne(ScreenManager screenManager) {
        this.screenManager = screenManager;
        create();
    }


    public void create() {

        player = new Player();
        enemy = new Enemy();

        books = new Array<>();

        gameBackground = new Texture(Gdx.files.internal("game1/backgroundGameOne.jpg"));
        gamePause = new Texture(Gdx.files.internal("game1/game1Pause.png"));

    }


    @Override
    public void render(float delta) {

        pause();

        if (isGamePaused) {
            screenManager.getBatch().begin();
            screenManager.getBatch().draw(gamePause, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            screenManager.getBatch().end();
            return;
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


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
    }

    private void createBook() {
        Book book = new Book(MathUtils.random(0, 950), MathUtils.random(0, 700)); //TODO: limits!
        books.add(book);
    }

    public void pause() {

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                isGamePaused = true;
            }

        if(isGamePaused && Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            isGamePaused=false;
        }
    }

}
