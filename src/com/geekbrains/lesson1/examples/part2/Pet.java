package com.geekbrains.lesson1.examples.part2;

public interface Pet {

    String name = "name";

    String voice();

    void loveMaster();

    boolean isUseful();

    default int run() {
        test();
        return 3;
    }

    static void test() {

    }

    private void test2() {

    }

}
