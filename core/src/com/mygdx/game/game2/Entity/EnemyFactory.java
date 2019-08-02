package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;
import com.mygdx.game.game2.PlayerEnergy;

public abstract class EnemyFactory {

    public static Enemy createEnemy(EnemyType enemyType, PlayerEnergy playerEnergy, EntityManager em){

        int x;
        Enemy en;

        switch (enemyType){

            case ENEMY32:
                x = MathUtils.random(400, 600 - TextureManager.Game2.ENEMY64.getWidth());
                en = new Enemy(TextureManager.Game2.ENEMY64,new Vector2(x,322), new Vector2(0,0), playerEnergy, em);
                en.setVelocity(300);
                return en;
            case ENEMY64:
                x = MathUtils.random(216, 705 - TextureManager.Game2.ENEMY96.getWidth());
                en = new Enemy(TextureManager.Game2.ENEMY96,new Vector2(x,255), new Vector2(0,0), playerEnergy, em);
                en.setVelocity(250);
                return en;
            case ENEMY128:
                x = MathUtils.random(0, 790 - TextureManager.Game2.ENEMY128.getWidth());
                en = new Enemy(TextureManager.Game2.ENEMY128,new Vector2(x,181), new Vector2(0,0), playerEnergy, em);
                en.setVelocity(150);
                return en;
            default:
                x = MathUtils.random(400, 600 - TextureManager.Game2.ENEMY64.getWidth());
                en = new Enemy(TextureManager.Game2.ENEMY64,new Vector2(x,322), new Vector2(0,0), playerEnergy, em);
                en.setVelocity(30);
                return en;

        }
    }
}
