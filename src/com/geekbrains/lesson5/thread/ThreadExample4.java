package com.geekbrains.lesson5.thread;

public class ThreadExample4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        MyThreadWithFlag thread = new MyThreadWithFlag();
        thread.start();

        Thread.sleep(2000);
        thread.setStopped(true);

        System.out.println("main stop");
    }
}
