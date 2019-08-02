package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ScreenManager;

public class DesktopLauncher {
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 768;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ScreenManager(), config);

		config.width = GAME_WIDTH;
		config.height= GAME_HEIGHT;
	}
}
