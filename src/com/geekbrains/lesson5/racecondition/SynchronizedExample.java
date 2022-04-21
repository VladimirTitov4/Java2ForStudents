package com.geekbrains.lesson5.racecondition;

public class SynchronizedExample {

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        System.out.println("Main start");
        Thread thread1 = new Thread(example::method1);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.method2();
            }
        });

        thread1.start();
        thread2.start();
    }

    public synchronized void method1() {
//        synchronized (this) {
            System.out.println("Method 1 START!");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        }
        System.out.println("Method 1 END!");
    }

    public synchronized void method2() {
//        synchronized (this) {
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
//        }
    }
}
