package com.IslandMolel.Animals;

public abstract class Carnivore extends Animal {
    public Carnivore(int x, int y) {
        super(x, y);
    }

    public Carnivore() {

    }

    @Override
    public void reproduce() {
        if (isAlive && hasPartner()) {
            // Проверка, что хищник жив и есть партнер для размножения
            if (Math.random() < 0.3) {
                // Пример: с вероятностью 30% размножение происходит успешно
                System.out.println(getClass().getSimpleName() + " is reproducing!");
                Carnivore newCarnivore = createNewCarnivore(); // Создание нового хищника
                placeNewAnimal(newCarnivore); // Размещение нового хищника в окружающей среде
            } else {
                System.out.println(getClass().getSimpleName() + " failed to reproduce.");
            }
        }
    }


    protected abstract Carnivore createNewCarnivore();

    protected abstract void placeNewAnimal(Carnivore newCarnivore);


    @Override
    public void move() {
        if (isAlive) {
            int newX = x + getRandomDirection();
            int newY = y + getRandomDirection();

            // Проверка, что новые координаты находятся в пределах острова
            if (isValidPosition(newX, newY)) {
                System.out.println(getClass().getSimpleName() + " is hunting and moving to (" + newX + ", " + newY + ")");
                x = newX;
                y = newY;
            }
        }
    }


    protected int getRandomDirection() {
        return Math.random() < 0.5 ? -1 : 1;
    }
}