package com.IslandMolel.Herbivores;

import com.IslandMolel.Animals.Animal;
import com.IslandMolel.Animals.Herbivore;

public class Caterpillar extends Herbivore {
    public Caterpillar(int randomX, int randomY) {
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
    protected boolean hasPartner() {
        return false;
    }

    @Override
    protected Herbivore createNewHerbivore() {
        return null;
    }

    @Override
    protected void placeNewAnimal(Herbivore newHerbivore) {

    }
}
