package com.geekbrains.lesson2.examples;

import java.io.FileInputStream;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("testfile1.txt");
            byte[] bytes = fileInputStream.readAllBytes();
            String string = new String(bytes);
            System.out.println(string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
//            System.exit(1);
            System.out.println("Блок Finally");
            try {
                fileInputStream.close();
//                int a = 10 / 0;
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
            System.out.println("Конец блока finally");
        }
        System.out.println("Завершение программы");
    }

}
