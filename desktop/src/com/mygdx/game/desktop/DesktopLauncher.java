package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CrookedGame;
import com.mygdx.game.MainMenu;
import com.mygdx.game.ScreenManager;
import com.mygdx.game.game1.GameOne;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameOne(), config);

		config.width = 1024;
		config.height= 768;
	}
}
