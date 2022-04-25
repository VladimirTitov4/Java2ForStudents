package com.geekbrains.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {
        Consumer<String> consumer = System.err::println;

        Consumer<String> consumer1 = Test::printString;

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

    private static void printString(String string) {
        System.out.println(string);
    }

    private static Integer testMethod(Function<Integer, Integer> anonymousClass, Integer integer) {
        return anonymousClass.apply(integer);
    }

    // -Xmx52m -Xm

    /*
    elasticsearch:
        image: docker.elastic.co/elasticsearch/elasticsearch:7.16.2
        networks:
          - elastic-jaeger
        ports:
          - "9201:9200"
          - "9301:9300"
        expose:
          - "9200"
        restart: on-failure
        environment:
          - cluster.name=jaeger-cluster
          - discovery.type=single-node
          - ES_JAVA_OPTS=-Xms2g -Xmx2g
          - xpack.security.enabled=false
        volumes:
          - esdata:/usr/share/elasticsearch/data

     */


}
