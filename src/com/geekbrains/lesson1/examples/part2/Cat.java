package com.geekbrains.lesson1.examples.part2;

public class Cat extends Animal implements Pet {

    public Cat(String name, int age) {
        super(name, age);
    }

    protected String catInfo() {
        return "cat info";
    }

    @Override
    public String info() {
        return "This is cat";
    }

    @Override
    public String voice() {
        return "Murrr";
    }

    @Override
    public void loveMaster() {
        System.out.println("Love you master from cat");
    }

    @Override
    public boolean isUseful() {
        return false;
    }

    @Override
    public int run() {
        return 20;
    }
}
