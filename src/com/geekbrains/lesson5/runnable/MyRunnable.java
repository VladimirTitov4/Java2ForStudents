package com.geekbrains.lesson5.runnable;

public class MyRunnable implements Runnable {

    private final int delay;

    public MyRunnable(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Поток %s, счетчик %d%n", Thread.currentThread().getName(), i);
        }
        System.out.println(Thread.currentThread().getName() + " - закончил свою работу");
    }
}
