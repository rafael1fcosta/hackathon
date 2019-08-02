package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.TextureManager;
import com.mygdx.game.game2.MyMasterGame;

public class Aim extends Entity{

    private Pixmap pm;
    private final EntityManager entityManager;
    Rectangle rect = new Rectangle();
    private Entity enemyToKill;
    private OrthographicCamera camera;
    private static final float W = 0.1f;
    private static final float H = 0.1f;

    public Aim(EntityManager em) {
        super(new Texture(0,0, Pixmap.Format.RGB888),
                new Vector2(
                        (MyMasterGame.WIDTH - TextureManager.Game2.AIM128.getWidth())/2,
                        (MyMasterGame.HEIGHT - TextureManager.Game2.AIM128.getHeight())/2),
                new Vector2(0,0)
        );

        rect.set(0,0,W, H);
        this.entityManager = em;


        Pixmap pm = new Pixmap(Gdx.files.internal("game2/aim128.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(
                pm,
                TextureManager.Game2.AIM128.getWidth()/2,
                TextureManager.Game2.AIM128.getHeight()/2));
        pm.dispose();

        camera = new OrthographicCamera();
    }


    @Override
    public void render(SpriteBatch sb) {
        int x, y;
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){

            shot(Gdx.input.getX()  , MyMasterGame.HEIGHT - Gdx.input.getY() -40);
        }

        super.render(sb);
    }

    private boolean colision(float x, float y, Rectangle ret){
        int factorX = 20;
        int factorY = 30;
        return (x > ret.getX()+factorX && x < ret.getX() + ret.width -factorX &&
                y > ret.getY() + factorY && y < ret.getY() + ret.height - factorY);
    }

    private void shot(float x, float y){
        Array<Enemy> enemies = entityManager.getEnemies();
        for (Entity e: enemies) {
            if (colision(x, y, e.getBounds())){
                entityManager.delete(e);

                return;

            }
        }
    }



    @Override
    public void update() {

        if(enemyToKill!=null){
            System.out.println("SHOT");
            entityManager.delete(enemyToKill);
            enemyToKill = null;
        }


    }

}
