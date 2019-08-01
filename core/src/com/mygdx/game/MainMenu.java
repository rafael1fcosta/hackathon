package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class MainMenu extends ScreenAdapter {


    private ScreenManager screenManager;
    private Texture menuBackground = new Texture(Gdx.files.internal("mainmenubackground.jpg"));
    private Texture playButton = new Texture(Gdx.files.internal("menu/button_play.png"));
    private Texture exitButton = new Texture(Gdx.files.internal("menu/button_exit.png"));


    public MainMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    public void changeScreen() {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() > 104.8f && Gdx.input.getX() < 304.8f && Gdx.input.getY() > 334 && Gdx.input.getY() < 434) {
                System.out.println("aconteceu. parabens.");
                //screenManager.setScreen(new StoryMenu(screenManager));
            }
        }
    }

        @Override
        public void render ( float delta){

            screenManager.batch.begin();
            screenManager.batch.draw(menuBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            screenManager.batch.draw(playButton, Gdx.graphics.getWidth() / 5 - 200 / 2, Gdx.graphics.getHeight() / 2 - 100 / 2);
            screenManager.batch.draw(exitButton, Gdx.graphics.getWidth() / 2 - 200 / 2, Gdx.graphics.getHeight() / 2 - 100 / 2);
            changeScreen();
            screenManager.batch.end();
        }
    }
