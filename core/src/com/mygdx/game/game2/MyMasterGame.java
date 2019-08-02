package com.mygdx.game.game2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.game2.screen.GameScreen;
import com.mygdx.game.game2.screen.Screen;
import com.mygdx.game.game2.screen.ScreenManager;

public class MyMasterGame extends ScreenAdapter {

	public static int WIDTH = 480, HEIGHT = 800;
	private final com.mygdx.game.ScreenManager screenManager1;
	//Texture img;

	SpriteBatch batch;
	Camera camera;
	private boolean isGamePaused;
	private Texture gamePause;

	private ScreenManager screenManager;
	
	public MyMasterGame(com.mygdx.game.ScreenManager screenManager){
		this.screenManager1=screenManager;
		create();
	}

	public void create () {
/*		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		c*/
		batch = new SpriteBatch();
		camera = new OrthographicCamera(MyMasterGame.WIDTH, MyMasterGame.HEIGHT);
		//camera = new OrthographicCamera(1, h/w);
		//img = new Texture("badlogic.jpg");
		ScreenManager.setScreen(new GameScreen());

		gamePause = new Texture(Gdx.files.internal("game2/game2Pause.png"));

	}

	@Override
	public void render (float delta) {
		pause();

		if (isGamePaused) {
			batch.begin();
			batch.draw(gamePause, 0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.end();
			return;
		}

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
		//if (ScreenManager.getCurrentScreen()!=null)
		//	ScreenManager.getCurrentScreen().pause();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			isGamePaused = true;
		}

		if(isGamePaused && Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			isGamePaused=false;
		}
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen()!=null)
			ScreenManager.getCurrentScreen().resume();
	}

	}
