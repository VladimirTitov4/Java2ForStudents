package com.geekbrains.lesson1.examples.part1;

public class TestCat {

    public static void main(String[] args) {
        Animal animal = new Cat("Max", 5);
        animal.animalInfo();

        Cat cat = (Cat) animal;
        cat.catInfo();

        System.out.println(cat instanceof Cat);
        System.out.println(cat instanceof Animal);
        System.out.println(cat instanceof Object);

        primitiveCasting();

        animal = null;
    }

    public static void primitiveCasting() {
        int a = 5;
//        primitiveCasting();
    }
}
