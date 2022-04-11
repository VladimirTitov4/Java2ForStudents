package com.geekbrains.lesson2.examples;

import java.io.FileInputStream;
import java.io.IOException;

public class FileExample2 {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("testfile1.txt")) {
            byte[] bytes = fileInputStream.readAllBytes();
            String string = new String(bytes);
            System.out.println(string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Завершение программы");

        /*try (SomeStream stream = new SomeStream("test")) {
            System.out.println("SomeStream");
        } catch (Exception e) {

        }*/
    }
}
