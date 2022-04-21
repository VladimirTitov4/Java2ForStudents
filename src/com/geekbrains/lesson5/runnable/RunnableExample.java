package com.geekbrains.lesson5.runnable;

public class RunnableExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(200));
//        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Поток %s, счетчик %d%n", Thread.currentThread().getName(), i);
            }
        });
        thread2.start();
    }
}
