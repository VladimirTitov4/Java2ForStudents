package com.geekbrains.lesson2.examples;

public class SomeStream implements AutoCloseable {

    private String name;

    public SomeStream(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println("close method");
    }
}
