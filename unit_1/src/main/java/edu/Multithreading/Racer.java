package edu.Multithreading;

public class Racer {
    private String name;
    private int speed;
    private int count;

    public Racer(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
