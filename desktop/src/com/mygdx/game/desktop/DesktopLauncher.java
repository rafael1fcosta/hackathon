package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CrookedGame;
import com.mygdx.game.MainMenu;
import com.mygdx.game.OptionsMenu;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.game1.GameOne;
import com.mygdx.game.game2.MyMasterGame;

public class DesktopLauncher {
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 768;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ScreenManager(), config);

		config.width = GAME_WIDTH;
		config.height= GAME_HEIGHT;

	//	new LwjglApplication(new GameOne(), config);
	//	new LwjglApplication(new MyMasterGame(), config);



	}
}
