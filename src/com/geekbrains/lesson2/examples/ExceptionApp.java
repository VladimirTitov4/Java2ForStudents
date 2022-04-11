package com.geekbrains.lesson2.examples;

import java.io.IOException;

public class ExceptionApp {

    public static void main(String[] args) {

        try {
            someMethod();
            anotherMethod();
            int[] array = {1, 2, 3};
            System.out.println(array[400]);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Было деление на ноль или NPE");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Обращение к несуществующему индексу массива");
        } catch (IOException e) {

        }
        System.out.println("Программа завершена");
    }

    private static void someMethod() {
//        Object object = null;
//        object.getClass();
        int a = 0;
        if (a == 0) {
            throw new DivideByZeroException();
        }
        int b = 10 / a;
        System.out.println(b);
    }

    private static void anotherMethod() throws IOException, ArithmeticException, NumberFormatException, NullPointerException {
        throw new IOException();
    }
}
