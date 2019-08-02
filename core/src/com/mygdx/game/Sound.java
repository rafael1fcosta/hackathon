package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;

public class Sound extends ScreenAdapter {

    com.badlogic.gdx.audio.Sound sound;
    Music music;


    public void create() {

        Gdx.audio.newSound(Gdx.files.internal("sounds/shots.mp3"));

        Gdx.audio.newSound(Gdx.files.internal("sounds/beep.wav"));

        Gdx.audio.newMusic(Gdx.files.internal("sounds/em.mp3"));

        sound.play();
        music.play();
    }

    @Override
    public void dispose() {
        sound.dispose();
    }
}


