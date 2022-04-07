package com.geekbrains.lesson1.examples.part2;

public class Ship implements Waterfowl {

    @Override
    public int swim() {
        return 100_000_000;
    }

    @Override
    public String toString() {
        return "Ship";
    }
}
