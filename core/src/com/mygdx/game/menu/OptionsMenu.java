package com.mygdx.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.game1.GameOne;
import com.mygdx.game.game2.MyMasterGame;

public class OptionsMenu extends ScreenAdapter {


    private ScreenManager screenManager;
    private Texture background_city_choice = new Texture(Gdx.files.internal("menu/background_city_choice.jpg"));
    private Texture easyLifeButton = new Texture(Gdx.files.internal("menu/button_choose_an_easy_life.png"));
    private Texture investInYouButton = new Texture(Gdx.files.internal("menu/button_invest_in_yourself.png"));
    private Texture returnButton = new Texture(Gdx.files.internal("menu/button_return.png"));

    public OptionsMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void changeScreen() {
        if (Gdx.input.isTouched()) {

            if (Gdx.input.getX() >= getOptionsPosX() &&
                    Gdx.input.getX() <= getOptionsPosX() + easyLifeButton.getWidth()) {

                if (Gdx.input.getY() >= getOption3PosY() &&
                        Gdx.input.getY() <= getOption3PosY() + easyLifeButton.getHeight()) {
                    screenManager.setScreen(new Game2instructions(screenManager));
                }

                if (Gdx.input.getY() >= getOption2PosY() &&
                        Gdx.input.getY() <= getOption2PosY() + investInYouButton.getHeight()) {
                    screenManager.setScreen(new Game1instructionsMenu(screenManager));
                }

                // return = option 1
                if (Gdx.input.getY() >= getOption1PosY() &&
                        Gdx.input.getY() <= getOption1PosY() + returnButton.getHeight()) {
                    screenManager.setScreen(new MainMenu(screenManager));
                }
            }
        }
    }

    @Override
    public void render(float delta) {

        screenManager.batch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenManager.batch.draw(background_city_choice, 0, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        screenManager.batch.draw(easyLifeButton, getOptionsPosX(), getOption1PosY());
        screenManager.batch.draw(investInYouButton, getOptionsPosX(), getOption2PosY());
        screenManager.batch.draw(returnButton, getOptionsPosX(), getOption3PosY());


        changeScreen();
        screenManager.batch.end();
    }


    private float getOptionsPosX() {
        return (Gdx.graphics.getWidth() * 0.75f) - 132;
    }

    private float getOption1PosY() {
        return Gdx.graphics.getHeight() * 0.65f;
    }

    private float getOption2PosY() {
        return Gdx.graphics.getHeight() * 0.40f;
    }

    private float getOption3PosY() {
        return Gdx.graphics.getHeight() * 0.15f;
    }
}


