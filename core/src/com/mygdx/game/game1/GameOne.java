package com.mygdx.game.game1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.ScreenManager;

import java.awt.*;

public class GameOne extends ScreenAdapter {

    private CharSequence str = String.valueOf(Player.playerScore);

    private ScreenManager screenManager;

    private GameObject player;
    private GameObject enemy;

    private Texture gameBackground;

    private Array<GameObject> books;

    public GameOne(ScreenManager screenManager) {
        this.screenManager = screenManager;
        create();
    }


    public void create() {

        player = new Player();
        enemy = new Enemy();

        books = new Array<>();

        gameBackground = new Texture(Gdx.files.internal("backgroundGameOne.jpg"));

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CharSequence str = String.valueOf(Player.playerScore);

        screenManager.getBatch().begin();
        screenManager.getBatch().draw(gameBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screenManager.getBatch().draw(player.getTexture(), player.getX(), player.getY());

        //score
        ScreenManager.font.setColor(Color.ORANGE);
        ScreenManager.font.getData().setScale(3,3);

        ScreenManager.font.draw(screenManager.getBatch(), str, 380, 745);
        //ScreenManager.font.draw(screenManager.getBatch(), str, 500, 500);
        //end of score

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

}
