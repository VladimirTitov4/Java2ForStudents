package com.geekbrains.lesson1.examples.part22;

public class Calendar {

    public static void main(String[] args) {
        DayOfWeek january = DayOfWeek.MARCH;
        System.out.println("monthNumber = " + january.getRussianMonthName() + " and number is " + january.ordinal());


        /*DayOfWeek[] values = DayOfWeek.values();
        for (DayOfWeek value : values) {
            System.out.println(value);
        }*/

        DayOfWeek february = DayOfWeek.valueOf("FEBRARY");
        System.out.println(february);

    }
}
