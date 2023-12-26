package com.IslandMolel.Animals;

import com.IslandMolel.Plants.Plant;

public abstract class Animal extends LivingEntity {
    protected boolean isAlive;

    public Animal(int x, int y) {
        super(x, y);
        this.isAlive = true;
    }

    public Animal() {
        super();
    }

    @Override
    public void eat(LivingEntity food) {
        if (food != null && food.isAlive) {
            // Проверка, что есть пища и она жива
            if (this instanceof Herbivore && food instanceof Plant) {
                // Если животное травоядное и еда - растение
                // Логика поедания растения
                System.out.println(this.getClass().getSimpleName() + " is eating a plant at (" + food.x + ", " + food.y + ")");
                food.isAlive = false; // Растение умирает
            } else if (this instanceof Carnivore && food instanceof Animal) {
                // Если животное хищник и еда - другое животное
                // Логика поедания другого животного
                System.out.println(this.getClass().getSimpleName() + " is eating a " + food.getClass().getSimpleName() +
                        " at (" + food.x + ", " + food.y + ")");
                food.isAlive = false; // Другое животное умирает
            }
        }
    }

    @Override
    public void reproduce() {
        if (isAlive) {
            // Проверка, что животное живо
            if (hasPartner()) {
                // Проверка, что у животного есть партнер для размножения
                if (Math.random() < 0.5) {
                    // Пример: с вероятностью 50% размножение происходит успешно
                    System.out.println(getClass().getSimpleName() + " is reproducing!");
                    Animal newAnimal = createNewAnimal(); // Создание нового животного
                    placeNewAnimal(newAnimal); // Размещение нового животного в окружающей среде
                } else {
                    System.out.println(getClass().getSimpleName() + " failed to reproduce.");
                }
            }
        }
    }

    protected abstract boolean hasPartner();

    protected abstract Animal createNewAnimal();

    protected abstract void placeNewAnimal(Animal newAnimal);

    @Override
    public void move() {
        if (isAlive) {
            int newX = x + getRandomDirection();
            int newY = y + getRandomDirection();

            // Проверка, что новые координаты находятся в пределах острова
            if (isValidPosition(newX, newY)) {
                System.out.println(getClass().getSimpleName() + " is moving to (" + newX + ", " + newY + ")");
                x = newX;
                y = newY;
            }
        }
    }

    protected abstract int getRandomDirection();

    protected abstract boolean isValidPosition(int x, int y);

    @Override
    public void doAction() {
        // Общее действие
        eat(null);
        reproduce();
        move();
    }
}


