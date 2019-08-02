package com.mygdx.game.game2;

public class PlayerEnergy {

    private int energy = 100;

    public void getShot(){
        this.energy -= 1;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
