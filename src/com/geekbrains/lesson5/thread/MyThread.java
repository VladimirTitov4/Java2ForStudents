package com.geekbrains.lesson5.thread;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Поток %s, счетчик %d%n", Thread.currentThread().getName(), i);
        }
    }
}
