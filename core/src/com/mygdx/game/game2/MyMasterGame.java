package com.mygdx.game.game2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.game2.screen.GameScreen;
import com.mygdx.game.game2.screen.ScreenManager;

public class MyMasterGame extends ApplicationAdapter {

	public static int WIDTH = 480, HEIGHT = 800;
	//Texture img;

	SpriteBatch batch;
	Camera camera;
	
	@Override
	public void create () {
/*		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		c*/
		batch = new SpriteBatch();
		camera = new OrthographicCamera(MyMasterGame.WIDTH, MyMasterGame.HEIGHT);
		//camera = new OrthographicCamera(1, h/w);
		//img = new Texture("badlogic.jpg");
		ScreenManager.setScreen(new GameScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (ScreenManager.getCurrentScreen()!=null) {

			ScreenManager.getCurrentScreen().update();
			ScreenManager.getCurrentScreen().render(batch);
		}
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();


	}
	
	@Override
	public void dispose () {
		if (ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().dispose();
		batch.dispose();
		//img.dispose();
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().pause();
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().resume();
	}
}
