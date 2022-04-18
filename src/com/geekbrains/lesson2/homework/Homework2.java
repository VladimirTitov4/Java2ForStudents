package com.geekbrains.lesson2.homework;

public class Homework2 {

    public static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String[][] CORRECT_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4", "5"},
            {"1", "2", "3", "4"}
    };


    public static void main(String[] args) {
        try {
            int sum = sumArrayValues(CORRECT_DATA);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sumArrayValues(String[][] array) {
        int sum = 0;
        if (checkArraySize(array)) {
            for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
                String[] row = array[rowIndex];
                for (int colIndex = 0; colIndex < row.length; colIndex++) {
                    String value = row[colIndex];
                    try {
                        sum += Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(rowIndex, colIndex);
                    }
                }
            }
        }
        return sum;
    }

    private static boolean checkArraySize(String[][] array) {
        if (array.length != REQUIRED_ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        for (String[] row : array) {
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }

        return true;
    }
}
