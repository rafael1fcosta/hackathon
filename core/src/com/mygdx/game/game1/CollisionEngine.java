package com.mygdx.game.game1;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class CollisionEngine {

    public static void checkForBookPicked(GameObject player, Array<GameObject> books) {


        for (int i = 0; i < books.size; i++) {

            if (player.getRectangle().contains(books.get(i).getRectangle())) {
                books.removeIndex(i);
            }

        }
    }



    public static void playerCanMove(Player player, Array<Rectangle> collidables, Direction direction) {



        switch (direction) {


            // player x + width >= colidable x

            case RIGHT:

                for (Rectangle collidable : collidables) {

                    float xInitCol = collidable.x;
                    float xFCol = collidable.x + collidable.width;

                    float yInitCol = collidable.y;
                    float yFCol = collidable.y + collidable.height;

                    float xInitPlayer = player.getX();
                    float xFPlayer = player.getX() + player.getRectangle().width;

                    float yInitPlayer = player.getY();
                    float yFPlayer = player.getY() + player.getRectangle().height;



                if (player.getRectangle().x + player.getRectangle().width >= collidable.x) { // ok

                        if (player.getY() + player.getRectangle().height >= collidable.y //ok

                                && player.getY() <= collidable.y + collidable.height) { // ok

                            player.getRectangle().x -= 2;
                            player.setCanTurnRight(false);
                            return;
                        }
                    }
                }
                return;
            // X
            case LEFT:
                for (Rectangle collidable : collidables) {

                    if (player.getRectangle().x <= collidable.x + collidable.width) { // ok

                        if (player.getY() + player.getRectangle().height >= collidable.y && // ok

                                player.getY() <= collidable.y + collidable.height) { // ok

                            player.setCanTurnLeft(false);
                            return;
                        }
                    }
                }
                return;

            // Y
            case UP:
                for (Rectangle collidable : collidables) {

                    if (player.getRectangle().y + player.getRectangle().height >= collidable.y) { // ok

                        if (player.getX() + player.getRectangle().width >= collidable.x && // ok

                                player.getX() <= collidable.x + collidable.width) { // ok
                            player.setCanTurnUP(false);
                            return;
                        }
                    }
                }
                return;

            case DOWN:
                for (Rectangle collidable : collidables) {

                    if (player.getRectangle().y <= collidable.y + collidable.height) { // ok

                        if (player.getX() + player.getRectangle().width >= collidable.x && // ok

                                player.getX() <= collidable.x + collidable.width) { // ok

                            player.setCanTurnDown(false);
                            return;
                        }
                    }
                }
        }
    }
}
