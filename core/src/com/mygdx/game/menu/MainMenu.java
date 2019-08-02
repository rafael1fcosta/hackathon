package com.mygdx.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ScreenManager;

public class MainMenu extends ScreenAdapter {


    private ScreenManager screenManager;
    private Texture menuBackground = new Texture(Gdx.files.internal("menu/mainmenubackground.jpg"));
    private Texture playButton = new Texture(Gdx.files.internal("menu/button_play.png"));
    private Texture exitButton = new Texture(Gdx.files.internal("menu/button_exit.png"));
    private Texture tailButton = new Texture(Gdx.files.internal("menu/CT.png"));

    public static Music music;


    public MainMenu(ScreenManager screenManager) {
        this.screenManager = screenManager;
        create();

    }

    public void create(){
        // Gdx.audio.newSound(Gdx.files.internal("sounds/shots.wav"));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/em.mp3"));
        music.setLooping(true);
        music.play();
    }

    public void changeScreen() {

        if (Gdx.input.isTouched()) {

            if (Gdx.input.getX() > 155f && Gdx.input.getX() < 357f &&
                    Gdx.input.getY() > 642.7f && Gdx.input.getY() < 739.7f) {
                screenManager.setScreen(new Lore(screenManager));
            }

            if (Gdx.input.getX() > 667f && Gdx.input.getX() < 869f &&
                    Gdx.input.getY() > 642.7f && Gdx.input.getY() < 739.7f) {
                System.exit(0);
            }
        }
    }

    @Override
    public void render(float delta) {

        screenManager.batch.begin();
        screenManager.batch.draw(menuBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screenManager.batch.draw(playButton, Gdx.graphics.getWidth() * 0.25f - 202 / 2, Gdx.graphics.getHeight() * 0.10f - 97 / 2);
        screenManager.batch.draw(exitButton, Gdx.graphics.getWidth() * 0.75f - 202 / 2, Gdx.graphics.getHeight() * 0.10f - 97 / 2);
        screenManager.batch.draw(tailButton, Gdx.graphics.getWidth() * 0.15f, Gdx.graphics.getHeight() * 0.70f);
        changeScreen();
        screenManager.batch.end();
    }



}
