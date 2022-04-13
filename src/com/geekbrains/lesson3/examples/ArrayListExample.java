package com.geekbrains.lesson3.examples;

import java.util.*;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add("fifth");

        stringList.contains("123");

//        System.out.println(stringList);

        stringList.remove(4);

//        System.out.println(stringList);


        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(5);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(1);

        integerList.add(1, 1);

        Collections.sort(integerList);


        Integer[] intsArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(intsArray));

        Object[] objects = targetList.toArray();


//        System.out.println("integerList.contains(5) = " + integerList.contains(5));

        /*if (!stringList.isEmpty()){
            System.out.println("коллекция не пустая");
        }*/

        int thirdIndex = stringList.indexOf("third");
//        System.out.println("thirdIndex = " + thirdIndex);

        stringList.set(2, "new third");

//        System.out.println(stringList);


        /*integerList.removeIf(integer -> integer.equals(1));

        Iterator<Integer> iterator = integerList.iterator();
        for (; iterator.hasNext();) {
            Integer next = iterator.next();
            if (next.equals(1)) {
                iterator.remove();
            }
        }*/

//        System.out.println(integerList);

        asListExample();
    }

    private static void asListExample() {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        integerList.add(1);
        System.out.println(integerList);
    }

















}
