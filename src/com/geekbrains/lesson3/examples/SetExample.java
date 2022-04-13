package com.geekbrains.lesson3.examples;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Person vasiliy = new Person("Vasiliy", "Zlobin", 30);
        Person eugene = new Person("Evgenij", "Denisenko", 25);
        Person ekaterina = new Person("Ekaterina", "Petrova", 20);


        Set<Person> personSet = new TreeSet<>();
        personSet.add(vasiliy);
        personSet.add(ekaterina);
        personSet.add(eugene);

        System.out.println(personSet);
    }
}
