package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.menu.Lore;
import com.mygdx.game.menu.MainMenu;

import java.util.HashMap;

public class ScreenManager extends Game {

  public static   SpriteBatch batch;
    public static ShapeRenderer shapeRenderer;
    public static BitmapFont font;
    public static HashMap<ScreenType, ScreenAdapter> screenMap;

    MainMenu mainMenu;


    @Override
    public void create () {



        screenMap=new  HashMap<>();

        screenMap.put(ScreenType.MAINMENU, new Lore(this));

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        setScreen(screenMap.get(ScreenType.MAINMENU));


    }

    @Override
    public void dispose () {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}

