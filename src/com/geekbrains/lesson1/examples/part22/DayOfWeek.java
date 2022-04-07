package com.geekbrains.lesson1.examples.part22;

public enum DayOfWeek {

    JANUARY("январь"),
    FEBRUARY("февраль"),
    MARCH("март"),
    APRIL("апрель"),
    MAY("май");

    private String russianMonthName;

    DayOfWeek(String russianMonthName) {
        this.russianMonthName = russianMonthName;
    }

    public String getRussianMonthName() {
        return russianMonthName;
    }
}
