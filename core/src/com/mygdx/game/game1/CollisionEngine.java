package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class CollisionEngine {

    public static boolean checkForBookPicked(GameObject player, Array<GameObject> books) {

        for (int i = 0; i < books.size; i++) {

            if (player.getRectangle().contains(books.get(i).getRectangle())) {
                books.removeIndex(i);
                Player player1 = (Player) player;
                player1.addPlayerScore();
                return true;
            }
        }
        return false;
    }


    public static void playerCanMove(Player player, Array<Rectangle> collidables, Direction direction) {

        float playerMinX = player.getX() + 200 * Gdx.graphics.getDeltaTime() * direction.x;
        float playerMinY = player.getY() + 200 * Gdx.graphics.getDeltaTime() * direction.y;
        float playerMaxX = player.getRectangle().width + playerMinX;
        float playerMaxY = player.getRectangle().height + playerMinY;

        for (Rectangle collidable : collidables) {
            if (playerMinX <= collidable.x + collidable.width
                    && playerMaxX >= collidable.x
                    && playerMinY <= collidable.y + collidable.height
                    && playerMaxY >= collidable.y) {
                player.setCurrentDirection(null);
            }

        }

    }

    public static boolean checkEnemyHit(GameObject player, GameObject enemy) {

        if (player.getRectangle().contains(enemy.getRectangle())) {
            return true;
        }
        return false;
    }

    public static boolean bookOutOfBounds(Book book, Array<Rectangle> collidables) {

        float bookMinX = book.getX();
        float bookMinY = book.getY();
        float bookMaxX = book.getRectangle().width + bookMinX;
        float bookMaxY = book.getRectangle().height + bookMinY;

        for (Rectangle collidable : collidables) {
            if (bookMinX <= collidable.x + collidable.width
                    && bookMaxX >= collidable.x
                    && bookMinY <= collidable.y + collidable.height
                    && bookMaxY >= collidable.y) {
                return true;
            }
        }
        return false;
    }
}
