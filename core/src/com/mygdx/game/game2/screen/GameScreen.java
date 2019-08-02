package com.mygdx.game.game2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.game2.Entity.EntityManager;
import com.mygdx.game.game2.Entity.Player;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.TextureManager;

public class GameScreen extends Screen {

    private OrthographicCamera camera;
    private Player player;
    private EntityManager entityManager;

    @Override
    public void create() {
        camera = new OrthographicCamera(MyMasterGame.WIDTH, MyMasterGame.HEIGHT);
        camera.setToOrtho(false);
        int i = MathUtils.random(10, 17);
        entityManager = new EntityManager(i);
    }

    @Override
    public void update() {
        camera.update();
        //layer.update();
        entityManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw( TextureManager.Game2.BACKGROUND,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        entityManager.render(sb);
        //player.render(sb);
        sb.end();
        if (entityManager.gameOver()) {
            System.out.println("Game Over");
            pause();
        }


    }

    @Override
    public void resize(int width, int height) {
        camera.update();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
