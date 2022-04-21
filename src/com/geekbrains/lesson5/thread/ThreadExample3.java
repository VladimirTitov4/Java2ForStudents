package com.geekbrains.lesson5.thread;

public class ThreadExample3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Старт потока main");
        MyThread thread = new MyThread("Поток кастомный");
        thread.start();
        thread.join();
        System.out.println("Финиш потока main");
    }
}
