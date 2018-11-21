package edu;
/**
 * Класс задаёт общие характеристики щенка.
 */
public class Puppy extends Dog {
    //Поле хранит значение породы мамы.
    private String momBreed;
    //Поле хранит значние породы папы.
    private String dadBreed;
    /**
     * Конструктор.
     * @param name Имя.
     * @param age Возраст.
     */
    public Puppy(String name, int age) {
        super(name, age);
    }
    /**
     * Перезагруженный констрктор.
     * @param name Имя.
     * @param age Возраст.
     * @param momBreed Порода мамы.
     * @param dadBreed Порода папы.
     */
    public Puppy(String name, int age, String momBreed, String dadBreed) {
        super(name, age);
        this.momBreed = momBreed;
        this.dadBreed = dadBreed;
    }
    /**
     * Переопределённый метод eat.
     */
    @Override
    public void eat() {
        System.out.println(getName() + " is drinking milk");
    }
    /**
     * Переопределённый метод sleep.
     */
    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }
    /**
     * Переопределённый метод bark.
     */
    @Override
    public void bark() {
        System.out.println(getName() + " is barking");
    }
    /**
     * Метод описывает занятие щенка - щенок любит играть.
     */
    public void play() {
        System.out.println(getName() + " is played");
    }
    /**
     * Метод задаёт значение попроды мамы.
     * @param momBreed Порода мамы.
     */
    public void setMomBreed(String momBreed) {
        this.momBreed = momBreed;
    }
    /**
     * Метод возвращает значение породы мамы.
     * @return Порода мамы.
     */
    public String getMomBreed() {
        return momBreed;
    }
    /**
     * Метод задаёт значение породы папы.
     * @param dadBreed Порода папы.
     */
    public void setDadBreed(String dadBreed) {
        this.dadBreed = dadBreed;
    }
    /**
     * Метод возвращает значение породы папы.
     * @return Порода папы.
     */
    public String getDadBreed() {
        return dadBreed;
    }
}
