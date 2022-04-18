package com.geekbrains.lesson2.homework;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Неверный размер массива, требуется 4х4");
    }
}
