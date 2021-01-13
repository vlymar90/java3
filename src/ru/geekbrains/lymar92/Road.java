package ru.geekbrains.lymar92;

import java.util.concurrent.BrokenBarrierException;

public class Road extends Stage {
    private final Object lock = new Object();
    private static boolean isWin = false;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

            if (length == 40 && !isWin) {
                    isWin = true;
                    System.out.println(c.getName() + " WIN");
                }
            if (length == 40) {
                try {
                    MainClass.cyclicBarrier.await();
                    if (isWin) {
                        isWin = false;
                        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                    }
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
