package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.TextureManager;


public class EntityManager {

    private final Array<Entity> entities = new Array<>();
    private final Player player;

    public EntityManager(int count) {


        this.player = new Player(
                new Vector2((MyMasterGame.WIDTH - TextureManager.Game2.PLAYER.getWidth()) / 2, 0),
                new Vector2(0, 0),
                this
        );

        for (int i = 0; i < count; i++) {
            float x = MathUtils.random(0, MyMasterGame.WIDTH - TextureManager.Game2.ENEMY.getWidth());
            float y = MathUtils.random(MyMasterGame.HEIGHT, MyMasterGame.HEIGHT * 2);
            float speed = MathUtils.random(2, 5);
            addEntity(
                    new Enemy(new Vector2(x, y), new Vector2(0, -speed))
            );
        }

    }

    public void update() {
        for (Entity e : entities)
            e.update();
        player.update();

        for (Missile m : getMissiles())
            if(m.checkEnd())
                entities.removeValue(m, false);
        checkColisions();
    }

    public void render(SpriteBatch sb) {
        for (Entity e : entities)
            e.render(sb);
        player.render(sb);
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

    private Array<Enemy> getEnemies() {
        Array<Enemy> ret = new Array<>();
        for (Entity e : entities)
            if (e instanceof Enemy)
                ret.add((Enemy) e);
        System.out.println("Enemy="+ ret.size);
        return ret;
    }

    private Array<Missile> getMissiles() {
        Array<Missile> ret = new Array<>();
        for (Entity e : entities)
            if (e instanceof Missile)
                ret.add((Missile) e);
        System.out.println("Missile=" + ret.size);

        return ret;
    }

    public boolean gameOver() {
        return (getEnemies().size == 0);
    }


}
