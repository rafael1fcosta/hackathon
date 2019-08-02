package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.TextureManager;
import com.mygdx.game.game2.PlayerEnergy;

public class EntityManager {

    private ScreenManager screenManager;
    private final Array<Entity> entities = new Array<>();
    private final Aim aim;
    private PlayerEnergy playerEnergy = new PlayerEnergy();
    private int shot = 0;

    public EntityManager(int count) {


       for (int i = 0; i < count; i++) {

            addEntity(
                    EnemyFactory.createEnemy(EnemyType.values()[MathUtils.random(0,2)], playerEnergy, this)
            );
        }

        aim = new Aim(this);
        addEntity(aim);
    }

    public void update() {
        for (Entity e : entities)
            e.update();

        for (Missile m : getMissiles())
            if(m.checkEnd())
                delete(m);
        checkColisions();
    }

    public void render(SpriteBatch sb) {
        if (shot > 0){
            sb.draw( TextureManager.Game2.BACKGROUND_RED,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            shot = 0;
        }

        for (int i = 0; i < entities.size; i++) {
            entities.get(i).render(sb);
        }
    }

    private void checkColisions(){
        for (Enemy e: getEnemies())
            for (Missile m: getMissiles())
                if (e.getBounds().contains(m.getBounds())){
                    entities.removeValue(e, false);
                    entities.removeValue(m, false);
                }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Array<Enemy> getEnemies() {
        Array<Enemy> ret = new Array<>();
        for (Entity e : entities)
            if (e instanceof Enemy)
                ret.add((Enemy) e);
        return ret;
    }

    private Array<Missile> getMissiles() {
        Array<Missile> ret = new Array<>();
        for (Entity e : entities)
            if (e instanceof Missile)
                ret.add((Missile) e);

        return ret;
    }

    public boolean gameOver() {

        return (getEnemies().size == 0 || playerEnergy.getEnergy() <= 0);
    }


    public void shot() {
        this.shot += 1;
    }

    public void delete(Entity e) {
       try {
            entities.removeValue(e, false);
        } catch (Exception ignored){
        }

    }

    public int getEnergy() {
       return playerEnergy.getEnergy();
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }
}
