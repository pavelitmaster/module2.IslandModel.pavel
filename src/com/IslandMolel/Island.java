package com.IslandMolel;

import com.IslandMolel.Animals.Animal;
import com.IslandMolel.Animals.Carnivore;
import com.IslandMolel.Animals.Herbivore;
import com.IslandMolel.Animals.LivingEntity;
import com.IslandMolel.Herbivores.*;
import com.IslandMolel.Plants.Plant;
import com.IslandMolel.Predators.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Island {
    private static final int SIZE_X = 100;
    private static final int SIZE_Y = 20;
    private static final int INITIAL_ANIMALS_COUNT = 10;
    private static final int INITIAL_PLANTS_COUNT = 10;

    private static final int INITIAL_HERBIVORES_COUNT = 10;
    private static final int INITIAL_CARNIVORES_COUNT = 10;


    private LivingEntity[][] grid;
    private ExecutorService animalThreadPool;
    private ScheduledExecutorService scheduler;

    public Island() {
        grid = new LivingEntity[SIZE_X][SIZE_Y];
        animalThreadPool = Executors.newFixedThreadPool(10);
        scheduler = Executors.newScheduledThreadPool(2);

        initializeGrid();
        spawnInitialEntities();
        startSimulation();
    }

    private void initializeGrid() {
        grid = new LivingEntity[SIZE_X][SIZE_Y];

    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < SIZE_X && y >= 0 && y < SIZE_Y;
    }

    private void spawnInitialEntities() {
        // Создание и размещение растений
        for (int i = 0; i < INITIAL_PLANTS_COUNT; i++) {
            Plant plant = new Plant(getRandomX(), getRandomY());
            placeEntity(plant);
        }

        // Создание и размещение травоядных
        for (int i = 0; i < INITIAL_HERBIVORES_COUNT; i++) {
            Herbivore herbivore = createRandomHerbivore();
            placeEntity(herbivore);
        }

        // Создание и размещение хищников
        for (int i = 0; i < INITIAL_CARNIVORES_COUNT; i++) {
            Carnivore carnivore = createRandomCarnivore();
            placeEntity(carnivore);
        }
    }

    private int getRandomX() {
        return (int) (Math.random() * SIZE_X);
    }

    private int getRandomY() {
        return (int) (Math.random() * SIZE_Y);
    }


    private void placeEntity(LivingEntity entity) {
        int entityX = entity.x;
        int entityY = entity.y;

        // Проверка, что координаты находятся в пределах острова
        if (isValidPosition(entityX, entityY)) {
            if (grid[entityX][entityY] == null) {
                // Ячейка острова пуста, размещаем
                grid[entityX][entityY] = entity;
                System.out.println("Placed " + entity.getClass().getSimpleName() + " at (" + entityX + ", " + entityY + ")\n" +
                        "---------------------------");
            } else {
                // Ячейка уже занята, поэтому ищем ближайшую свободную ячейку
                findAndPlaceInNearestFreeCell(entity);
            }
        } else {
            System.out.println("Cannot place " + entity.getClass().getSimpleName() + " at invalid position.");
        }
    }

    private void findAndPlaceInNearestFreeCell(LivingEntity entity) {
        int entityX = entity.x;
        int entityY = entity.y;

        // Перебираем ближайшие ячейки в поиске свободной
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = entityX + dx;
                int newY = entityY + dy;

                if (isValidPosition(newX, newY) && grid[newX][newY] == null) {
                    // Нашли свободную ячейку, размещаем
                    grid[newX][newY] = entity;
                    System.out.println("Placed " + entity.getClass().getSimpleName() + " at nearest free cell (" + newX + ", " + newY + ")\n" +
                            "---------------------------");
                    return;
                }
            }
        }

        // Если не удалось найти свободную ячейку, выводим сообщение
        System.out.println("Cannot place " + entity.getClass().getSimpleName() + ". No free cells available.\n" +
                "---------------------------");
    }

    private Herbivore createRandomHerbivore() {
        int randomX = getRandomX();
        int randomY = getRandomY();

        //создание травоядного
        Herbivore herbivore = null;

        double random = Math.random();
        if (random < 0.3) {
            herbivore = new Rabbit(randomX, randomY) {
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
            };
        } else if (random < 0.6) {
            herbivore = new Deer(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Boar(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Horse(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Caterpillar(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Duck(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Goat(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Mouse(randomX, randomY);
        } else if (random < 0.6) {
            herbivore = new Horse(randomX, randomY);
        } else if (random < 0.6) {
        } else
            herbivore = new Buffalo(randomX, randomY);
        System.out.println("Created " + herbivore.getClass().getSimpleName() + " at (" + randomX + ", " + randomY + ")\n" +
                "---------------------------");
        return herbivore;
    }

    private Carnivore createRandomCarnivore() {
        int randomX = getRandomX();
        int randomY = getRandomY();

        // Создание хищников
        Carnivore carnivore = null;
        double random = Math.random();
        if (random < 0.3) {
            carnivore = new Wolf(randomX, randomY) {
                @Override
                protected Carnivore createNewCarnivore() {
                    return null;
                }

                @Override
                protected void placeNewAnimal(Carnivore newCarnivore) {
                }

                @Override
                protected boolean isValidPosition(int x, int y) {
                    return false;
                }
            };
        } else if (random < 0.6) {
            carnivore = new Fox(randomX, randomY);
        } else if (random < 0.6) {
            carnivore = new Boa(randomX, randomY);
        } else if (random < 0.6)
            carnivore = new Bear(randomX, randomY);
        else
            carnivore = new Eagle(randomX, randomY);

        System.out.println("Created " + carnivore.getClass().getSimpleName() + " at (" + randomX + ", " + randomY + ")\n" +
                "---------------------------");
        return carnivore;
    }

    private void startSimulation() {

    }


}
