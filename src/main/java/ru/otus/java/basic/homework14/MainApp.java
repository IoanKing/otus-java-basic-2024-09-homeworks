package ru.otus.java.basic.homework14;

import ru.otus.java.basic.homework14.Exeptions.AppArrayDataException;
import ru.otus.java.basic.homework14.Exeptions.AppArraySizeException;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("===Домашняя работа по лекции #14===");
        System.out.println("===================================");
        String[][] array = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arraySizeException = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arrayDataException = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "s2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        int result = -1;
        result = arraySum(array);
        System.out.println(result);
        result = arraySum(arrayDataException);
        System.out.println(result);
        result = arraySum(arraySizeException);
        System.out.println(result);
    }

    public static int arraySum(String[][] array) throws RuntimeException {
        if (array.length != 4 || array[0].length !=4) {
            throw new AppArraySizeException("Массив имеет ширину и/или высоту более 4");
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array.length; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new AppArrayDataException("В ячейке [" + i + "][" + j + "] лежат не целые числа.");
        }
        return sum;
    }

}
