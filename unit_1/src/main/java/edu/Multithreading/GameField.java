package edu.Multithreading;

import java.util.Random;

public class GameField  {
    private static final int DISTANCE = 10;

    public static synchronized void addSymbol(Racer racer, int distance) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int count = 0;
        while (count <= distance){
            for(int i = 0; i <= random.nextInt(racer.getSpeed()/10); i++) {
                sb.append("-");
                count++;
            }
            System.out.println(sb + racer.getName());

            Thread.sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Racer racer1 = new Racer("Tom", 40);
        Racer racer2 = new Racer("Bob", 20);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    addSymbol(racer1, DISTANCE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    addSymbol(racer2, DISTANCE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        long before2 = System.currentTimeMillis();
        runnable2.run();


        long after2 = System.currentTimeMillis();

        long resultTime2 = after2- before2;

        System.out.println(resultTime2);

        long before1 = System.currentTimeMillis();
        runnable1.run();

        long after1 = System.currentTimeMillis();

        long resultTime1 = after1 - before1;

        System.out.println(resultTime1);

        System.out.println(resultTime1 > resultTime2 ? racer2.getName() + " быстрее" : racer1.getName() + " быстрее");

    }
}
