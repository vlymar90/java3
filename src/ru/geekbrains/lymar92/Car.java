package ru.geekbrains.lymar92;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    Object lock = new Object();
    public static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static boolean isFree = true;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cyclicBarrier.await();
            MainClass.cyclicBarrier.reset();

//            synchronized (lock) {
                if(isFree) {
                    isFree = false;
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}


