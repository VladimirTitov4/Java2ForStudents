package com.geekbrains.lesson1.examples.part1;

public class Animal {

    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String animalInfo() {
        return "Animal info";
    }

}
