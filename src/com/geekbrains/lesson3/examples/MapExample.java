package com.geekbrains.lesson3.examples;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>(); // по hashCode()
        Map<String, String> linkedHashMap = new LinkedHashMap<>(); // в порядке добавления
        Map<String, String> treeMap = new TreeMap<>(); // отсортированные по ключу
        
        hashMap.put("Russia", "Moscow");
        hashMap.put("India", "Delhi");
        hashMap.put("England", "London");

        for (Map.Entry<String, String> pair : hashMap.entrySet()) {
//            System.out.println("Country: " + pair.getKey() + " has capital = " + pair.getValue());
        }

        String capital = hashMap.getOrDefault("Japan", "нет данных"); // O(1)
        System.out.println("capital = " + capital);

    }
}
