package com.mygdx.game.game1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.ScreenManager;

public class GameOne extends ScreenAdapter {

    private SpriteBatch batch;

    private GameObject player;

    private Array<GameObject> books;

    private ScreenManager screenManager;

    public GameOne(ScreenManager screenManager){
        this.screenManager=screenManager;
        create();
    }



    public void create() {

        player = new Player();

        books = new Array<>();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        screenManager.batch.begin();

        screenManager.batch.draw(player.getTexture(), player.getX(), player.getY());

        for (GameObject book : books) {
            book.render(batch);
        }

        player.render(batch);

        screenManager.batch.end();


         CollisionEngine.checkForBookPicked(player, books);


        if (Math.random() * 100 < 0.5) {
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
}
