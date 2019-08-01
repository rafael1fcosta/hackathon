package com.mygdx.game.game2.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.game2.Entity.EntityManager;
import com.mygdx.game.game2.Entity.Player;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.game2.TextureManager;

public class GameScreen extends Screen {

    private OrthographicCamera camera;
    private Player player;
    private EntityManager entityManager = new EntityManager(1);

    @Override
    public void create() {
        camera = new OrthographicCamera(MyMasterGame.WIDTH, MyMasterGame.HEIGHT);
        camera.setToOrtho(false);

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

        sb.draw( TextureManager.Game2.BACKGROUND,0,0);
        entityManager.render(sb);
        //player.render(sb);
        sb.end();

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
