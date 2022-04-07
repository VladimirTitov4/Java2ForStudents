package com.geekbrains.lesson1.examples.part3;

public class Judgement {

    public static final String JUDGEMENT_NAME = "name";

    public static void main(String[] args) {
        prepations();

        Lawyer lawyer1 = new Lawyer();
    }

    private static void prepations() {
        Judgement judgement = new Judgement();
        Lawyer lawyer = new Lawyer();
        Person vladimir = new Person("Vladimir", 35);
        boolean age = judgement.isGuilty(lawyer, vladimir);
        System.out.println(age);
    }

    private boolean isGuilty(Diplomable lawyer, Person person) {
        return lawyer.judge(person.getAge());
    }

}
