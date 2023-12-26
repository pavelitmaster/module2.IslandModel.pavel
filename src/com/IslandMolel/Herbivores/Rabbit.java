package com.IslandMolel.Herbivores;

import com.IslandMolel.Animals.Animal;
import com.IslandMolel.Animals.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit(int x, int y) {
        super(x, y);
    }
    // ...

    @Override
    protected boolean hasPartner() {
        return Math.random() < 0.5;
    }

    @Override
    protected Animal createNewAnimal() {
        return null;
    }

    @Override
    protected void placeNewAnimal(Animal newAnimal) {

    }

    @Override
    protected boolean isValidPosition(int x, int y) {
        return false;
    }

    @Override
    protected Herbivore createNewHerbivore() {
        // Логика создания нового кролика
        return new Rabbit(x, y) {
            @Override
            protected Animal createNewAnimal() {
                return null;
            }

            @Override
            protected void placeNewAnimal(Animal newAnimal) {

            }

            @Override
            protected int getRandomDirection() {
                return 0;
            }

            @Override
            protected boolean isValidPosition(int x, int y) {
                return false;
            }
        };
    }

    @Override
    protected void placeNewAnimal(Herbivore newHerbivore) {

    }
}