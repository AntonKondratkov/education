package edu;
/**
 * Класс задаёт общие характеристики домашнего животного.
 */
public class Animal {
    //Поле хранит значение имени.
    private String name;
    //Поле хранит значение возраста.
    private int age;
    /**
     * Конструктор.
     * @param name Имя.
     * @param age Возраст.
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /**
     * Метод задаёт действие живоного - принимать пищу.
     */
    public void eat() {
        System.out.println(getName() + " is eating");
    }
    /**
     * Метод задаёт действие животного - спать.
     */
    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }
    /**
     * Метод задаёт значение имени.
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод возвращает значение имени.
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод задаёт значение возраста.
     * @param age Возраст.
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Метод возвращает значение возраста.
     * @return Возраст.
     */
    public int getAge() {
        return this.age;
    }
}
