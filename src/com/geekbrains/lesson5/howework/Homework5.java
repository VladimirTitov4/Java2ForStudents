package com.geekbrains.lesson5.howework;

import java.util.Arrays;

public class Homework5 {

    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        float[] data1 = createArray(SIZE);
        float[] data2 = createArray(SIZE);

        measureTime(() -> sequentialMethod(data1), "последовательный метод");
        measureTime(() -> parallelMethod(data2), "Параллельный метод");

        System.out.println("Массивы равны? " + Arrays.equals(data1, data2));
    }

    private static float[] createArray(int size) {
        float[] data = new float[size];
        Arrays.fill(data, 1.0f);
        return data;
    }

    private static void sequentialMethod(float[] data) {
        sequentialMethod(data, 0);
    }

    private static void sequentialMethod(float[] data, int offset) {
        for (int i = 0; i < data.length; i++) {
            float currentValue = data[i];
            data[i] = computeValue(i + offset, currentValue);
        }
    }

    private static void parallelMethod(float[] data) {
        float[] part1 = Arrays.copyOfRange(data, 0, HALF_SIZE);
        float[] part2 = Arrays.copyOfRange(data, HALF_SIZE, data.length);

        Thread thread1 = new Thread(() -> sequentialMethod(part1, 0));
        Thread thread2 = new Thread(() -> sequentialMethod(part2, HALF_SIZE));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Соединение прервано");
            e.printStackTrace();
            return;
        }

        System.arraycopy(part1, 0, data, 0, HALF_SIZE);
        System.arraycopy(part2, 0, data, HALF_SIZE, HALF_SIZE);

    }

    private static float computeValue(int index, float currentValue) {
        return (float)(currentValue * Math.sin(0.2f + index / 5.0) * Math.cos(0.2f + index / 5.0) * Math.cos(0.4f + index / 2.0));
    }

    private static void measureTime(Runnable action, String actionName) {
        long start = System.currentTimeMillis();
        action.run();
        long finish = System.currentTimeMillis();
        long duration = finish - start;
        System.out.printf("Метод %s занял %d ms%n", actionName, duration);
//        System.out.printf("Метод %s занял %d ms%n", actionName, TimeUnit.NANOSECONDS.toNanos(duration));
    }
}
