package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Enemy extends GameObject {


    public Enemy() {
        super(x, y, new Texture(Gdx.files.internal()));
    }

    @Override
    public void render(Batch batch) {

    }
}
