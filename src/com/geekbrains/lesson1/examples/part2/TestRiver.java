package com.geekbrains.lesson1.examples.part2;

public class TestRiver {

    public static void main(String[] args) {
        River river = new River("Volga", 100);
        Waterfowl dog = new Dog("Jack", 3, "husky");
        Waterfowl duck = new Duck("Duck", 1);
        Waterfowl ship = new Ship();
        Pet cat = new Cat("Max", 4);
        Bird bird = new Bird("bird", 1);


        swimAcrossRiver(river, dog, duck, ship);
        flyAcrossRiver(river, bird);
//        flyAcrossRiver(river, cat);
//        flyAcrossRiver(river, dog);

        System.out.println(bird instanceof Flyable);
        System.out.println(dog instanceof Flyable);
    }

    private static void swimAcrossRiver(River river, Waterfowl ...waterfowls) {
        for (Waterfowl waterfowl : waterfowls) {
            System.out.println(waterfowl);
            System.out.println(river.canSwim(waterfowl));
            System.out.println("---");
        }
    }

    private static void flyAcrossRiver(River river, Flyable flyable) {

    }
}
