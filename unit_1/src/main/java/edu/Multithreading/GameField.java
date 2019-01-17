package edu.Multithreading;

import java.lang.management.ManagementFactory;
import java.util.Random;

public class GameField  {
    private static final int DISTANCE = 20;
    private static int count = 0;
    private static  String name;
    private static Racer racerWin;

    public void addSymbol(Racer racer) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (racer.getCount() <= DISTANCE){
            for(int i = 0; i <= random.nextInt(racer.getSpeed()/10); i++) {
                sb.append("-");
                racer.setCount(count++);
                //Определение победителя по пройденному расстоянию.
                if (count >= DISTANCE) {
                    name = racer.getName();
                    racerWin = racer;
                    break;
                }
            }
            System.out.println(sb + racer.getName());
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws InterruptedException {
    GameField gameField = new GameField();
    Racer racer1 = new Racer("Tom", 40);
    Racer racer2 = new Racer("Bob", 70);
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

        thread1.join();
        thread2.join();

        System.out.println(name + " Победил " + "он проехал расстояние " + racerWin.getCount() + " метров" );

    }
}

