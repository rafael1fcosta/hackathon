package com.mygdx.game.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Player extends GameObject {

    private Direction currentDirection;
    private Array<Rectangle> collidables;

    public static int playerScore = 0;


    public Player() {
        super(366, 42, new Texture(Gdx.files.internal("game1/playerReal.png")));
    }

    public void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            currentDirection = Direction.LEFT;

            CollisionEngine.playerCanMove(this, collidables, Direction.LEFT);

            if (currentDirection == null) {
                return;
            }

            getRectangle().x -= 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().x < 0) {
                getRectangle().x = 0;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            currentDirection = Direction.RIGHT;

            CollisionEngine.playerCanMove(this, collidables, Direction.RIGHT);

            if (currentDirection == null) {
                return;
            }

            getRectangle().x += 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().x > 1024 - 40) {
                getRectangle().x = 1024 - 40;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            currentDirection = Direction.UP;

            CollisionEngine.playerCanMove(this, collidables, Direction.UP);

            if (currentDirection == null) {
                return;
            }

            getRectangle().y += 200 * Gdx.graphics.getDeltaTime();

            if (getRectangle().y > 768 - 50) {
                getRectangle().y = 768 - 50;
                return;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            currentDirection = Direction.DOWN;

            CollisionEngine.playerCanMove(this, collidables, Direction.DOWN);

            if (currentDirection == null) {
                return;
            }

            getRectangle().y -= 200 * Gdx.graphics.getDeltaTime();

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

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    public void addPlayerScore() {
        this.playerScore ++;
    }

}
