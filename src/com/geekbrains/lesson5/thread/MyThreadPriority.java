package com.geekbrains.lesson5.thread;

public class MyThreadPriority extends Thread {

    public MyThreadPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("Поток %s начал свою работу с приоритетом %d%n",
                Thread.currentThread().getName(),
                Thread.currentThread().getPriority());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Поток %s, счетчик %d%n", Thread.currentThread().getName(), i);
        }
    }
}
