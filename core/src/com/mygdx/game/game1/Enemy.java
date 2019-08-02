package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Enemy extends GameObject {

    private long playerX;
    private long playerY;

    public Enemy() {
        super(0, 0, new Texture(Gdx.files.internal("game1/skeleton.png")));

    }


    @Override
    public void render(Batch batch) {
        move();
    }

    private void move() {

    }

    private void setPlayerPosition(long playerX, long playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }
}
