package com.geekbrains.lesson1.examples.part22;

public class Iphone {

    private String modelName;
    private Color color;

    public Iphone(String modelName, Color color) {
        this.modelName = modelName;
        this.color = color;
    }

    public static void main(String[] args) {
        Iphone iphone = new Iphone("iphone 5", Color.BLACK);
    }
}
