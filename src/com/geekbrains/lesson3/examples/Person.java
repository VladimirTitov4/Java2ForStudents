package com.geekbrains.lesson3.examples;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final String name;
    private final String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Person anotherPerson) {
        return Integer.compare(this.age, anotherPerson.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }


    /*
    1. Если объекты равны по equals() то и hashCode() будет одинаковый
    2. Если hashCode() одинаковый, то не обязательно равны (коллизия)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    /*
    1. Метод hashCode() вызывается при добавлении элемента в список (HashSet)
    2. На основе hashCode() вычисляется индекс ячейки, в которую будет ращмещен элемент
    3. Если hashCode() одинаковый - то будет произведено сравение объектов. И если объекты:
    - одинаковые - то добавлять не нужно
    - разные - то 2 и более объекта будут размещены в одной и той же ячейке, но в связанном списке
     */
    @Override
    public int hashCode() {
        return 1;
    }
}
