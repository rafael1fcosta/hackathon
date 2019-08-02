package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Player extends GameObject {

//    private boolean canTurnRight = true;
//    private boolean canTurnLeft = true;
//    private boolean canTurnUP = true;
//    private boolean canTurnDown = true;

    private Direction currentDirection;

    private Array<Rectangle> collidables;

    public Player() {
        super(0, 0, new Texture(Gdx.files.internal("game1/wizardLeftRed.png")));
    }

    public void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            currentDirection = Direction.LEFT;

            CollisionEngine.playerCanMove(this, collidables, Direction.LEFT);

//            if (!canTurnLeft) {
//                canTurnUP = true;
//                canTurnDown = true;
//                canTurnRight = true;
//                System.out.println("CANT TURN LEFT");
//                return;
//            }

            if (currentDirection == null) {
                return;
            }

            getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();

//            canTurnUP = true;
//            canTurnDown = true;
//            canTurnRight = true;

            if (getRectangle().x < 0) {
                getRectangle().x = 0;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            currentDirection = Direction.RIGHT;

            CollisionEngine.playerCanMove(this, collidables, Direction.RIGHT);

//            if (!canTurnRight) {
//                canTurnLeft = true;
//                canTurnDown = true;
//                canTurnUP = true;
//                System.out.println("CANT TURN RIGHT");
//                return;
//            }

            if (currentDirection == null) {
                return;
            }

            getRectangle().x += 200 * Gdx.graphics.getDeltaTime();
//            canTurnLeft = true;
//            canTurnDown = true;
//            canTurnUP = true;

            if (getRectangle().x > 1024 - 40) { //TODO: change with img size and put in finals
                getRectangle().x = 1024 - 40;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            currentDirection = Direction.UP;

            CollisionEngine.playerCanMove(this, collidables, Direction.UP);
//
//            if (!canTurnUP) {
//                canTurnDown = true;
//                canTurnLeft = true;
//                canTurnRight = true;
//                System.out.println("CANT TURN UP");
//                return;
//            }

            if (currentDirection == null) {
                return;
            }

            getRectangle().y += 200 * Gdx.graphics.getDeltaTime();
//            canTurnDown = true;
//            canTurnLeft = true;
//            canTurnRight = true;

            if (getRectangle().y > 768 - 50) {
                getRectangle().y = 768 - 50;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            CollisionEngine.playerCanMove(this, collidables, Direction.DOWN);

//            if (!canTurnDown) {
//                canTurnUP = true;
//                canTurnRight = true;
//                canTurnLeft = true;
//                System.out.println("CANT TURN DOWN");
//                return;
//            }


            getRectangle().y -= 200 * Gdx.graphics.getDeltaTime();
//            canTurnUP = true;
//            canTurnRight = true;
//            canTurnLeft = true;

            if (getRectangle().y < 0) {
                getRectangle().y = 0;
            }
        }

    }

    @Override
    public void render(Batch batch) {
        move();
    }

    public float getX() {
        return getRectangle().x;
    }

    public float getY() {
        return getRectangle().y;
    }

    public void setTexture(Texture texture) {
        super.setTexture(texture);
    }

    public void addCollidables(Array<Rectangle> collidables) {
        this.collidables = collidables;

    }

    public void setCanTurnRight(boolean canTurnRight) {
        this.canTurnRight = canTurnRight;
    }

    public void setCanTurnLeft(boolean canTurnLeft) {
        this.canTurnLeft = canTurnLeft;
    }

    public void setCanTurnUP(boolean canTurnUP) {
        this.canTurnUP = canTurnUP;
    }

    public void setCanTurnDown(boolean canTurnDown) {
        this.canTurnDown = canTurnDown;
    }
}
