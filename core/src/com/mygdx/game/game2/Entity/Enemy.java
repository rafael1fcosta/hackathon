package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.TextureManager;
import com.mygdx.game.game2.PlayerEnergy;


public class Enemy extends Entity {

    private final PlayerEnergy playerEnergy;
    private final EntityManager entityManager;
    private float delta, deltaI;
    private Sound shoot;

    //public Enemy(EnemyType typeEnemy, Vector2 pos, Vector2 direction) {
    public Enemy(Texture texture, Vector2 pos, Vector2 direction, PlayerEnergy playerEnergy, EntityManager entityManager) {
        super(texture, pos, direction );
        this.playerEnergy = playerEnergy;
        this.entityManager = entityManager;
    }

    public void setVelocity(float delta){
        this.delta = Gdx.graphics.getDeltaTime() * delta;

    }

    public void setDelta(float delta) {
        this.delta = delta;
    }


    @Override
    public void update() {
        pos.add(direction);

        if (pos.y <= -TextureManager.Game2.ENEMY.getHeight()) {
            float x = MathUtils.random(0, MyMasterGame.WIDTH - TextureManager.Game2.ENEMY.getWidth());
            pos.set(x,MyMasterGame.HEIGHT );
        }

        deltaI += Gdx.graphics.getDeltaTime();

        if (deltaI > delta  ){
            shoot();
            deltaI = 0;
        }

    }

    private void shoot() {
        playerEnergy.getShot();
        entityManager.shot();
        shoot = Gdx.audio.newSound(Gdx.files.internal("sounds/shots.mp3"));
        shoot.play();
        System.out.println("Shoot " + texture.toString());
    }
}
