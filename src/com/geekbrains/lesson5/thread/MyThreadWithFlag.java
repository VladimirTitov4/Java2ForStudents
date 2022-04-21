package com.geekbrains.lesson5.thread;

public class MyThreadWithFlag extends Thread {

    private boolean stopped;

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Поток был остановлен");
                    break;
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Поток был остановлен во время сна");
                break;
            }
            System.out.printf("Поток %s, счетчик %d%n", Thread.currentThread().getName(), i);
        }
    }
}
