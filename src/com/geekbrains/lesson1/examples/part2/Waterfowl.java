package com.geekbrains.lesson1.examples.part2;

public interface Waterfowl {

    int swim();

    default int run() {
        return 10;
    }

}
