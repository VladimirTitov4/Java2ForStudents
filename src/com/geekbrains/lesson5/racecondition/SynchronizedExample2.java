package com.geekbrains.lesson5.racecondition;

public class SynchronizedExample2 {

    private final String lock = "";

    public static void main(String[] args) {
        SynchronizedExample2 t1 = new SynchronizedExample2();
        SynchronizedExample2 t2 = new SynchronizedExample2();

        Thread thread1 = new Thread(t1::method1);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t2.method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    public void method1() {
        synchronized (lock) {
            System.out.println("Method 1 START!");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Method 1 END!");
    }

    public void method2() {
        synchronized (lock) {
            System.out.println("Method 2 START!");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Method 2 END!");
        }
    }
}

