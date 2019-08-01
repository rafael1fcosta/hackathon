package com.mygdx.game.game2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class TextureManager {

    public static String prefix ="game2/";

    public static class Game2 {
        public static  final Texture PLAYER = new Texture(Gdx.files.internal(prefix + "badlogic.jpg"));
        public static final Texture MISSILE = new Texture(Gdx.files.internal(prefix +"missile.png"));
        public static final Texture ENEMY = new Texture(Gdx.files.internal(prefix +"badlogic.jpg"));
        public static final Texture BACKGROUND = new Texture(Gdx.files.internal(prefix +"background.png"));

    }



}
