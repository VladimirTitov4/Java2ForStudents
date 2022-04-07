package com.geekbrains.lesson1.examples.part1;

public class Test {

    private static int count;
    private int anotherCount;

    public static void main(String[] args) {
        Test test = (Test) new Test();
        test.hashCode();
        test.getClass();
        test.info();

        Test.voice();
    }

    public void info() {
        count++;
    }

    public static void voice() {
//        anotherCount++;
    }
}
