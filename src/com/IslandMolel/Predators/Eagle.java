package com.IslandMolel.Predators;

import com.IslandMolel.Animals.Animal;
import com.IslandMolel.Animals.Carnivore;

public class Eagle extends Carnivore {

    public Eagle(int randomX, int randomY) {
        super();
    }

    @Override
    protected boolean hasPartner() {
        return false;
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
    protected Carnivore createNewCarnivore() {
        return null;
    }

    @Override
    protected void placeNewAnimal(Carnivore newCarnivore) {

    }
}
