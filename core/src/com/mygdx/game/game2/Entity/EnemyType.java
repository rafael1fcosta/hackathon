package com.mygdx.game.game2.Entity;

public enum EnemyType {
    ENEMY32(1),
    ENEMY64(2),
    ENEMY128(3);

    private final int value;

    EnemyType(int i) {
        this.value = i;
    }

    public EnemyType getEnemyType(int i) {
        if (i==1) return ENEMY32;
        if (i==2) return ENEMY64;
        if (i==3) return ENEMY128;
        return ENEMY32;
    }


}
