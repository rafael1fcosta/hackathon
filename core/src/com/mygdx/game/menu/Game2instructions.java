package com.mygdx.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.game1.GameOne;
import com.mygdx.game.game2.MyMasterGame;

public class Game2instructions extends ScreenAdapter {

        private ScreenManager screenManager;
        private Texture instructions = new Texture(Gdx.files.internal("game2/game2Instructions.png"));

        public Game2instructions(ScreenManager screenManager) {
            this.screenManager = screenManager;
        }

        public void changeScreen() {

            Gdx.input.setInputProcessor(new InputAdapter() {

                @Override
                public boolean keyDown(int keyCode) {
                    if (keyCode == Input.Keys.RIGHT) {
                        screenManager.setScreen(new MyMasterGame(screenManager));
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

            screenManager.batch.draw(instructions, (Gdx.graphics.getWidth() - 848)/2, (Gdx.graphics.getHeight() - 258)/2);
            changeScreen();
            screenManager.batch.end();
        }

        @Override
        public void dispose() {
            Gdx.input.setInputProcessor(null);
        }
    }
