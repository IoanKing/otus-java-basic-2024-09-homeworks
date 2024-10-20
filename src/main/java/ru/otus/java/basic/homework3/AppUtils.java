package ru.otus.java.basic.homework3;

import java.util.Arrays;

public class AppUtils {
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
     * @param arr - ссылка на обрабатываемый двумерный массив
     * @param minValue - нижняя граница диапазона случайного числа
     * @param maxValue - верхняя граница диапазона случайного числа
     */
    public static void fillTwoDimensionalArrayRandomValues (int[][] arr, int minValue, int maxValue) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = getRandomInt(minValue, maxValue);
            }
        }
    }

    /**
     * Метод печатающий двумерный массив отдельными строчками
     * @param arr - ссылка на двумерный массив
     */
    public static void printTwoDimensionalArray(int[][] arr) {
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
