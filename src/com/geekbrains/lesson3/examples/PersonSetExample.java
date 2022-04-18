package com.geekbrains.lesson3.examples;

import java.util.HashSet;
import java.util.Set;

public class PersonSetExample {

    public static void main(String[] args) {
        Person vasiliy = new Person("Vasiliy", "Zlobin", 30);
        Person eugene = new Person("Evgenij", "Denisenko", 25);
        Person ekaterina = new Person("Ekaterina", "Petrova", 20);

        Set<Person> personSet = new HashSet<>();
        personSet.add(vasiliy);
        personSet.add(ekaterina);
        personSet.add(eugene);

    }
}
