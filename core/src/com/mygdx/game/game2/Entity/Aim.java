package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
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

    private final EntityManager entityManager;
    Rectangle rect = new Rectangle();
    private Entity enemyToKill;
    private OrthographicCamera camera;
    private static final int W = 6;
    private static final int H = 6;

    public Aim(EntityManager em) {
        super(new Texture(0,0, Pixmap.Format.RGB888),
                new Vector2(
                        (MyMasterGame.WIDTH - TextureManager.Game2.AIM128.getWidth())/2,
                        (MyMasterGame.HEIGHT - TextureManager.Game2.AIM128.getHeight())/2),
                new Vector2(0,0)
        );
        rect.setWidth(W);
        rect.setHeight(H);
        this.entityManager = em;

        /*rect = new Rectangle(
                MyMasterGame.WIDTH/2,
                MyMasterGame.HEIGHT,
                texture.getWidth(),
                texture.getHeight()
        );*/

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

            Vector2 touchPos = new Vector2(Gdx.input.getX()  ,MyMasterGame.HEIGHT - Gdx.input.getY());
           // touchPos.x -= W;
           // touchPos.y -= H;
           // touchPos.set(Gdx.input.getX(), Gdx.input.getY());
           // camera.translate(touchPos);
            // touchPos.x -= texture.getWidth() / 2;
            //touchPos.x -= TextureManager.Game2.AIM128.getWidth() / 2;
            //touchPos.y -= texture.getHeight() / 2;
            //touchPos.y -= TextureManager.Game2.AIM128.getHeight() / 2;
            //rect.setCenter(touchPos.x, touchPos.y);
            rect.setPosition(touchPos);
            shot(rect);

            //rect.setPosition(touchPos);
        }

        super.render(sb);
    }

    private void shot(Rectangle me){
        Array<Enemy> enemies = entityManager.getEnemies();
        for (Entity e: enemies) {
            if(e.getBounds().contains(me))
                this.enemyToKill = e;

        }
        update();
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
