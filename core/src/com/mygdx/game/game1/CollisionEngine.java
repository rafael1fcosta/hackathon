package com.mygdx.game.game1;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class CollisionEngine {

    public static void checkForBookPicked(GameObject player, Array<GameObject> books) {


        for (int i = 0; i < books.size; i++) {

            if(player.getRectangle().contains(books.get(i).getRectangle())) {
                books.removeIndex(i);
            }

        }
    }

    public static boolean playerCanMove(GameObject gameObject, Array<Rectangle> collidables) {

        for (Rectangle collidable : collidables) {

            if (gameObject.getRectangle().contains(collidable)) {
                return false;
            }
        }

        return true;
    }
}
