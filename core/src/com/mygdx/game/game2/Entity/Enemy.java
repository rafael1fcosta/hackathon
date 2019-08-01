package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.TextureManager;


public class Enemy extends Entity {

    public Enemy(Vector2 pos, Vector2 direction) {
        super(TextureManager.Game2.ENEMY, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);

        if (pos.y <= -TextureManager.Game2.ENEMY.getHeight()) {
            float x = MathUtils.random(0, MyMasterGame.WIDTH - TextureManager.Game2.ENEMY.getWidth());
            pos.set(x,MyMasterGame.HEIGHT );
        }
    }
}
