package com.mygdx.game.game1;

import com.badlogic.gdx.utils.Array;

public class CollisionEngine {

    public static void checkForBookPicked(GameObject player, Array<GameObject> books) {

        for (int i = 0; i < books.size; i++) {

            if (player.getRectangle().contains(books.get(i).getRectangle())) {
                books.removeIndex(i);
                Player player1 = (Player) player;
                player1.addPlayerScore();
            }
        }
    }
}
