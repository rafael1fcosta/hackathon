package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Player extends GameObject {


    public Player() {
        super(0, 0, new Texture(Gdx.files.internal("game1/wizardLeftRed.png")));
    }

    public void move() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().x < 0) {
                getRectangle().x = 0;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            getRectangle().x += 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().x > 1024 - 40) { //TODO: change with img size and put in finals
                getRectangle().x = 1024 - 40;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            getRectangle().y += 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().y > 768 - 50) {
                getRectangle().y = 768 - 50;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            getRectangle().y -= 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().y < 0) {
                getRectangle().y = 0;
            }
        }

    }

    @Override
    public void render(Batch batch) {

        move();
    }

    public float getX() {
        return getRectangle().x;
    }

    public float getY() {
        return getRectangle().y;
    }

    public void setTexture(Texture texture) {
        super.setTexture(texture);
    }

}
