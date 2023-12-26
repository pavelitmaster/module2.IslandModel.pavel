package com.IslandMolel.Animals;

public abstract class LivingEntity implements Runnable {
    public int x;
    public int y;
    protected boolean isAlive;

    public LivingEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public LivingEntity() {

    }

    public abstract void eat(LivingEntity food);

    public abstract void reproduce();

    public abstract void move();

    public abstract void doAction();

    @Override
    public void run() {
        while (true) {
            doAction();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}