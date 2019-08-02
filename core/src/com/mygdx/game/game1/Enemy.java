package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Enemy extends GameObject {

    private float playerX;
    private float playerY;

    public Enemy() {
        super(600, 600, new Texture(Gdx.files.internal("game1/skeleton.png")));

    }


    @Override
    public void render(Batch batch) {
        move();
        batch.draw(getTexture(), getX(), getY());
    }

    private void move() {

        int number = (int) (Math.random() * 2);

        if (number == 0) {
            if (getX() < playerX) {
                getRectangle().x += 175 * Gdx.graphics.getDeltaTime();
                return;
            }
            getRectangle().x -= 175 * Gdx.graphics.getDeltaTime();
            return;
        }

        if (getY() < playerY) {
            getRectangle().y += 175 * Gdx.graphics.getDeltaTime();
            return;
        }
        getRectangle().y -= 175 * Gdx.graphics.getDeltaTime();

    }

    public void setPlayerPosition(float playerX, float playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }
}
