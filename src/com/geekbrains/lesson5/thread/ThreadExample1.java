package com.geekbrains.lesson5.thread;

public class ThreadExample1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("Поток - 1");
        long startExecution = System.currentTimeMillis();
        thread1.start();
        thread1.join();
        long finishExecution = System.currentTimeMillis();
        System.out.println(finishExecution - startExecution);
    }
}
