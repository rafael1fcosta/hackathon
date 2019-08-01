package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.game1.GameOne;

public class MainMenu extends ScreenAdapter {


    private ScreenManager screenManager;

    private Texture menuBackground = new Texture(Gdx.files.internal("menu/mainmenubackground.jpg"));
    private Texture playButton = new Texture(Gdx.files.internal("menu/playButton.png"));
    private Texture exitButton = new Texture(Gdx.files.internal("menu/exitButton.jpg"));


    public MainMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    public void changeScreen() {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() > 104.8f && Gdx.input.getX() < 304.8f && Gdx.input.getY() > 334 && Gdx.input.getY() < 434) {

                screenManager.setScreen(new OptionsMenu(screenManager));

                 // screenManager.setScreen(new GameOne(screenManager));
                //screenManager.setScreen(new OptionsMenu(screenManager));

            }
        }
    }

    @Override
    public void render(float delta) {

        screenManager.batch.begin();

        screenManager.batch.draw(menuBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screenManager.batch.draw(playButton, Gdx.graphics.getWidth() / 5 - 200 / 2, Gdx.graphics.getHeight() / 2 - 100 / 2);
        screenManager.batch.draw(exitButton, Gdx.graphics.getWidth() / 2 - 200 / 2, Gdx.graphics.getHeight() / 2 - 100 / 2);
        changeScreen();
        screenManager.batch.end();
    }
}
