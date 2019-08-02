package com.mygdx.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ScreenManager;

    public class Game1GoodEnding extends ScreenAdapter {

        private ScreenManager screenManager;
        private Texture instructions = new Texture(Gdx.files.internal("game1/game1goodEnding.png"));

        public Game1GoodEnding(ScreenManager screenManager) {
            this.screenManager = screenManager;
        }

        public void changeScreen() {

            Gdx.input.setInputProcessor(new InputAdapter() {

                @Override
                public boolean keyDown(int keyCode) {
                    if (keyCode == Input.Keys.ESCAPE) {
                        screenManager.setScreen(new MainMenu(screenManager));
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

            screenManager.batch.draw(instructions, (Gdx.graphics.getWidth() - 908)/2, (Gdx.graphics.getHeight() - 146)/2);
            changeScreen();
            screenManager.batch.end();
        }

        @Override
        public void dispose() {
            Gdx.input.setInputProcessor(null);
        }
    }
