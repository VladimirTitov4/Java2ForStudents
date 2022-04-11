package com.geekbrains.lesson2.examples;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("Деление на ноль. Кастомный тип исключения");
    }

}
