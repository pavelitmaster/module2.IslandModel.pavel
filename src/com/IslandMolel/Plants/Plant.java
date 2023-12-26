package com.IslandMolel.Plants;

import com.IslandMolel.Animals.LivingEntity;

public class Plant extends LivingEntity {
    public Plant(int x, int y) {
        super(x, y);
    }

    @Override
    public void eat(LivingEntity food) {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move() {

    }

    @Override
    public void doAction() {
        reproduce();
    }
}