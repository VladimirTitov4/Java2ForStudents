package com.geekbrains.lesson1.howework.participant;

public class Robot implements Participant {

    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 1000;
    }

    @Override
    public int jump() {
        return 20;
    }

    @Override
    public int swim() {
        return 100;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
