package com.mygdx.game.game2.Entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.game2.MyMasterGame;
import com.mygdx.game.game2.TextureManager;


public class Missile extends Entity {

    public Missile(Vector2 pos) {
        super(TextureManager.Game2.MISSILE, pos, new Vector2(0, 5));
    }

    @Override
    public void update() {
        pos.add(direction);
    }

    public boolean checkEnd(){
        return pos.y >= MyMasterGame.HEIGHT;
    }
}
