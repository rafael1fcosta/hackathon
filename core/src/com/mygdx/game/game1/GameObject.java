package com.mygdx.game.game1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    private Texture texture;
    private Rectangle rectangle;

    public GameObject(long x, long y, Texture texture) {
        this.texture = texture;
        this.rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public abstract void render(Batch batch);

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {
        return rectangle.x;
    }

    public float getY() {
        return rectangle.y;
    }
}
