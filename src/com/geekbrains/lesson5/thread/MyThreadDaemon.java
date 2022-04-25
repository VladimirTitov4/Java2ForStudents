package com.geekbrains.lesson5.thread;

import com.geekbrains.lesson5.runnable.MyRunnable;

public class MyThreadDaemon {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(100), "Поток 1");
        Thread thread2 = new Thread(new MyRunnable(1000), "Поток 2");
        thread1.start();
        thread2.setDaemon(true);
        thread2.start();
    }
}
