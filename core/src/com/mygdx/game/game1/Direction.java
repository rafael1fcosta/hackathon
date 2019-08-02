package com.mygdx.game.game1;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, 1),
    DOWN(0, -1);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
