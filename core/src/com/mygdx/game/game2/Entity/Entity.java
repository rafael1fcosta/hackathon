package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {


    protected  Texture texture;
    protected  Vector2 pos;
    protected  Vector2 direction;

    public Entity(Texture texture, Vector2 pos, Vector2 direction) {
        this.texture = texture;
        this.pos = pos;
        this.direction = direction;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public abstract void update();

    public void render(SpriteBatch sb){
        sb.draw(texture, pos.x, pos.y);
    }

    public Vector2 getPos() {
        return pos;
    }

    public Rectangle getBounds(){
        return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
    }

    public  void setDirection(float x, float y){
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }
}
