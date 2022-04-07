package com.geekbrains.lesson1.examples.part2;

public abstract class Animal {

    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String animalInfo() {
        return "Animal info";
    }

    public abstract String info();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " name='" + name + '\'' +
                ", age=" + age;
    }
}
