package com.geekbrains.lesson5.racecondition;

public class Race {

    private volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Имя текущего потока " + Thread.currentThread().getName());
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printCount();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printCount();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Финальное значение переменной count = " + count);
    }

    private static void printCount() {
        for (int i = 0; i < 100; i++) {
//            count++;
            synchronized (Race.class) {
                System.out.println(Thread.currentThread().getName() + " : " + count++);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
