package com.IslandMolel.Animals;

public abstract class Herbivore extends Animal {
    public Herbivore(int x, int y) {
        super(x, y);
    }

    public Herbivore() {
        super();
    }

    @Override
    public void reproduce() {
        if (isAlive && hasPartner()) {
            // Проверка, что травоядное живо и есть партнер для размножения
            if (Math.random() < 0.5) {
                // Пример: с вероятностью 50% размножение происходит успешно
                System.out.println(getClass().getSimpleName() + " is reproducing!");
                Herbivore newHerbivore = createNewHerbivore(); // Создание нового травоядного
                placeNewAnimal(newHerbivore); // Размещение нового травоядного в окружающей среде
            } else {
                System.out.println(getClass().getSimpleName() + " failed to reproduce.");
            }
        }
    }

    protected abstract boolean hasPartner();

    protected abstract Herbivore createNewHerbivore();

    protected abstract void placeNewAnimal(Herbivore newHerbivore);

    @Override
    public void move() {
        if (isAlive) {
            int newX = x + getRandomDirection();
            int newY = y + getRandomDirection();

            // Проверка, что новые координаты находятся в пределах острова
            if (isValidPosition(newX, newY)) {
                System.out.println(getClass().getSimpleName() + " is grazing and moving to (" + newX + ", " + newY + ")");
                x = newX;
                y = newY;
            }
        }
    }

    protected int getRandomDirection() {
        return Math.random() < 0.5 ? -1 : 1;
    }


}