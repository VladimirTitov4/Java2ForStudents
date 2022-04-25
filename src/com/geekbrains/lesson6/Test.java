package com.geekbrains.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {
        Consumer<String> consumer = System.err::println;

        Function<Integer, Integer> function = integer -> {
            return integer * integer;
        };

//        testMethod(consumer, "message");

//        System.out.println(testMethod(function, 5));


        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");

        stringList.stream()
                .filter(s -> s.equals("second") || s.equals("third"))
                .map(s -> s + " - edited")
                .forEach(System.out::println);
    }

    private static void testMethod(Consumer<String> consumer, String message) {
        consumer.accept(message);
    }

    private static Integer testMethod(Function<Integer, Integer> anonymousClass, Integer integer) {
        return anonymousClass.apply(integer);
    }


}
