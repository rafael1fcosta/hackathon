package com.mygdx.game.menu;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.game1.GameOne;

public class Game1instructionsMenu extends ScreenAdapter {

    private ScreenManager screenManager;
    private Texture instructions = new Texture(Gdx.files.internal("game1/game1instructions.png"));

    public Game1instructionsMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void changeScreen() {

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.RIGHT) {
                    screenManager.setScreen(new GameOne(screenManager));
                    dispose();
                }
                return true;
            }
        });

    }

    @Override
    public void render(float delta) {

        screenManager.batch.begin();
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenManager.batch.draw(instructions, (Gdx.graphics.getWidth() - 887)/2, (Gdx.graphics.getHeight() - 362)/2);
        changeScreen();
        screenManager.batch.end();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }
}