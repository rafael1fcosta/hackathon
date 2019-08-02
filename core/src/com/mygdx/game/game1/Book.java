package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Book extends GameObject {

    private long randomX;
    private long randomY;

    public Book(long randomX, long randomY) {
        super(randomX, randomY, new Texture(Gdx.files.internal("game1/spellbook.png")));

        this.randomX = randomX;
        this.randomY = randomY;
    }

    @Override
    public void render(Batch batch) {

        batch.draw(getTexture(), randomX, randomY);
    }

    public void setTexture(Texture texture) {
        super.setTexture(texture);
    }

}
