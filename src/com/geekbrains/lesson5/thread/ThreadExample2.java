package com.geekbrains.lesson5.thread;

public class ThreadExample2 {

    public static void main(String[] args) {
//        Thread.currentThread().setPriority(7);
        MyThreadPriority thread1 = new MyThreadPriority("Поток - 1");
        MyThreadPriority thread2 = new MyThreadPriority("Поток - 2");
        thread1.setPriority(1);


        thread1.start();
        thread2.start();
    }
}
