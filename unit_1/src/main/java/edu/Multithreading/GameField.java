package edu.Multithreading;

import java.lang.management.ManagementFactory;
import java.util.Random;

public class GameField  {
    private static final int DISTANCE = 10;
    private static int count = 0;
    private static  String name;

    public void addSymbol(Racer racer) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (count <= DISTANCE){
            for(int i = 0; i <= random.nextInt(racer.getSpeed()/10); i++) {
                sb.append("-");
                count++;
            }
            System.out.println(sb + racer.getName());
            Thread.sleep(1000);
            //Определение победителя по пройденному расстоянию.
            if (count >= DISTANCE) {
                name = racer.getName();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
    GameField gameField = new GameField();
    Racer racer1 = new Racer("Tom", 40);
    Racer racer2 = new Racer("Bob", 60);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   gameField.addSymbol(racer1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    gameField.addSymbol(racer2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        long before1 = System.currentTimeMillis();
        thread1.join();
        long after1 = System.currentTimeMillis();

        long before2 = System.currentTimeMillis();
        thread2.join();
        long after2 = System.currentTimeMillis();

        long resultTime1 = after1 - before1;
        long resultTime2 = after2 - before2;

        System.out.println("Время " + racer1.getName() + ": " + resultTime1);
        System.out.println("Время " + racer2.getName() + ": " + resultTime2);

        System.out.println(name);

        //Определение победителя по времени.
        System.out.println(resultTime1 > resultTime2 ? racer2.getName() + " быстрее" : racer1.getName() + " быстрее");

    }
}

