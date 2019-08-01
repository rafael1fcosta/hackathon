package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class OptionsMenu extends ScreenAdapter {


    private ScreenManager screenManager;
    private Texture button = new Texture(Gdx.files.internal("button.png"));
    private Texture option1 = new Texture(Gdx.files.internal("option1.png"));
    private Texture option2 = new Texture(Gdx.files.internal("option2.png"));
    private Texture option3 = new Texture(Gdx.files.internal("option3.png"));




    public OptionsMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }


    public void changeScreen() {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() > 104.8f && Gdx.input.getX() < 304.8f && Gdx.input.getY() > 334 && Gdx.input.getY() < 434) {
                System.out.println("aconteceu. yay.");
                //screenManager.setScreen(new StoryMenu(screenManager));
            }
        }
    }

    @Override
    public void render ( float delta){

        screenManager.batch.begin();
        Gdx.gl.glClearColor(.25f, .45f, .7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenManager.batch.draw(button, (Gdx.graphics.getWidth() * 0.05f), Gdx.graphics.getHeight()* 0.10f);
        screenManager.batch.draw(option1,(Gdx.graphics.getWidth() * 0.11f), Gdx.graphics.getHeight()* 0.15f);

        screenManager.batch.draw(button, (Gdx.graphics.getWidth() * 0.5f- 300/2), Gdx.graphics.getHeight()* 0.35f);
        screenManager.batch.draw(option2, (Gdx.graphics.getWidth() * 0.56f -300/2), Gdx.graphics.getHeight()* 0.4f);


        screenManager.batch.draw(button, (Gdx.graphics.getWidth() * 0.65f), Gdx.graphics.getHeight()* 0.10f);
        screenManager.batch.draw(option2, (Gdx.graphics.getWidth() * 0.71f -300/2), Gdx.graphics.getHeight()* 0.15f);

        changeScreen();
        screenManager.batch.end();
    }
}


