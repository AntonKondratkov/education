package edu;
/**
 * Класс задаёт общие характеристики собаки.
 */
public class Dog extends Animal {
    //Поле хранит значение породы собаки.
    private String breed;
    /**
     * Конструктор.
     * @param name Имя.
     * @param age Возраст.
     */
    public Dog(String name, int age) {
        super(name, age);
    }
    /**
     * Перезагруженный конструктор.
     * @param name Имя.
     * @param age Возраст.
     * @param breed Порода.
     */
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    /**
     * Переопределённый метод eat.
     */
    @Override
    public void eat() {
        System.out.println(getName() + " is eating a meat");
    }
    /**
     * Переопределённый метод sleep.
     */
    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }
    /**
     * Метод bark (лаять), свойство характерное для собаки.
     */
    public void bark() {
        System.out.println(getName() + " is barking");
    }
    /**
     * Метод задаёт значение породы собаки.
     * @param breed Порода.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    /**
     * Метод возвращает значение породы собаки.
     * @return Порода.
     */
    public String getBreed() {
        return breed;
    }
}
