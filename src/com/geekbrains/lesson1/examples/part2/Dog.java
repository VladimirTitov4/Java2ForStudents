package com.geekbrains.lesson1.examples.part2;

public class Dog extends Animal implements Pet, Waterfowl {

    private String type;

    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    @Override
    public String info() {
        return "This is Dog and my name is " + Pet.name;
    }

    @Override
    public String voice() {
        return "Gav gav";
    }

    @Override
    public void loveMaster() {
        System.out.println("Loooove you master");
    }

    @Override
    public boolean isUseful() {
        return true;
    }

    @Override
    public int swim() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " and type is " + this.type;
    }

    @Override
    public int run() {
        return Pet.super.run();
    }
}
