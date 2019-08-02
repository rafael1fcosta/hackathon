package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class OptionsMenu extends ScreenAdapter {


    private ScreenManager screenManager;
    private Texture background_city_choice = new Texture(Gdx.files.internal("menu/background_city_choice.jpg"));
    private Texture option1 = new Texture(Gdx.files.internal("menu/button_invest_in_yourself.png"));
    private Texture option2 = new Texture(Gdx.files.internal("menu/button_choose_an_easy_life.png"));
    private Texture option3 = new Texture(Gdx.files.internal("menu/button_help_others.png"));





    public OptionsMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    public void changeScreen() {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() > 104.8f && Gdx.input.getX() < 304.8f && Gdx.input.getY() > 334 && Gdx.input.getY() < 434) {
                //screenManager.setScreen(new StoryMenu(screenManager));
            }
        }
    }

    @Override
    public void render ( float delta){

        screenManager.batch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenManager.batch.draw(background_city_choice, 0, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
        screenManager.batch.draw(option1,(Gdx.graphics.getWidth() * 0.75f) - 132, Gdx.graphics.getHeight()* 0.15f);
        screenManager.batch.draw(option2, (Gdx.graphics.getWidth() * 0.75f) -132, Gdx.graphics.getHeight()* 0.4f);
        screenManager.batch.draw(option3, (Gdx.graphics.getWidth() * 0.75f) - 132, Gdx.graphics.getHeight()* 0.65f);

        changeScreen();
        screenManager.batch.end();
    }
}


