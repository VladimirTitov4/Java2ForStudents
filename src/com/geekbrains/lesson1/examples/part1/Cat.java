package com.geekbrains.lesson1.examples.part1;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    protected String catInfo() {
        return "cat info";
    }
}
