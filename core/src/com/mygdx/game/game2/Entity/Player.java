package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;

public class Player extends Entity {

    private  EntityManager entityManager;
    private long lastFire;

    public Player(Vector2 pos, Vector2 direction, EntityManager entityManager) {
        super(TextureManager.Game2.PLAYER, pos, direction);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
            pos.add(direction);

        if (Gdx.input.isKeyPressed(Keys.LEFT))
            setDirection(-300, 0);
        else if (Gdx.input.isKeyPressed(Keys.RIGHT))
            setDirection(300, 0);
        else if (Gdx.input.isKeyPressed(Keys.UP))
            setDirection(0, 300);
        else
            setDirection(0, 0);

        if (Gdx.input.isKeyPressed(Keys.SPACE))
            if (System.currentTimeMillis()-lastFire >= 200){
            entityManager.addEntity(
                    new Missile(pos.cpy().add(
                            (TextureManager.Game2.PLAYER.getWidth() - TextureManager.Game2.MISSILE.getWidth())/2,
                            TextureManager.Game2.PLAYER.getHeight()
                        )
                    )
            );
            lastFire = System.currentTimeMillis();
        }
    }
}
