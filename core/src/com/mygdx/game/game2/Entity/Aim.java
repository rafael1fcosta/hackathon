package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Aim extends Entity {

    private final Camera camera;
    Rectangle rect;

    public Aim(Texture texture, Vector2 pos, Vector2 direction, Camera camera) {
        super(texture, pos, direction);
        this.camera  = camera;
        rect = new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update() {
        if (Gdx.input.isTouched()) {
            Vector2 touchPos = new Vector2();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            //camera.unproject(touchPos);
            touchPos.x -= 64 / 2;
            touchPos.y = touchPos.y -= 64 / 2;
            rect.setPosition(touchPos);
        }
        rect.setPosition(pos);
    }

    @Override
    public Vector2 getPos() {
        return super.getPos();
    }
}
