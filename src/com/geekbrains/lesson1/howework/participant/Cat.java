package com.geekbrains.lesson1.howework.participant;

public class Cat implements Participant {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 10;
    }

    @Override
    public int jump() {
        return 1;
    }

    @Override
    public int swim() {
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
