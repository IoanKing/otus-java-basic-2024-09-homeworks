package ru.otus.java.basic.homework3;

import java.util.Arrays;

public class AppUtils {
    final static int MIN_INT_VALUE = -9;
    final static int MAX_INT_VALUE = 9;
    final static int MIN_ARR_SIZE = 2;
    final static int MAX_ARR_SIZE = 6;

    /**
     * Метод генерирующий случайное целое число в заданном диапазоне
     * @param min - нижняя граница диапазона
     * @param max - верхняя граница диапазона
     * @return (int) - случайное число внутри указанного диапазона
     */
    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    /**
     * Метод заполняющий двумерный массив случайными числами
     */
    public static int[][] fillArrayRandomValues () {
        int arraySizeVertical = AppUtils.getRandomInt(MIN_ARR_SIZE + 1, MAX_ARR_SIZE);
        int arraySizeHorizontal = AppUtils.getRandomInt(MIN_ARR_SIZE + 1, MAX_ARR_SIZE);
        int[][] array = new int[arraySizeVertical][arraySizeHorizontal];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = getRandomInt(MIN_INT_VALUE, MAX_INT_VALUE);
            }
        }
        return array;
    }

    /**
     * Метод печатающий двумерный массив отдельными строчками
     * @param arr - ссылка на двумерный массив
     */
    public static void printArrayInConsole(int[][] arr) {
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
