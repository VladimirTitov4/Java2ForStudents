package com.geekbrains.lesson1.examples.part3;

public class Lawyer implements Diplomable {

    private String name;

    public boolean judge(int age) {
        return age > 18;
    }

    @Override
    public boolean hasDiploma() {
        return true;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name='" + name + '\'' +
                '}';
    }
}
