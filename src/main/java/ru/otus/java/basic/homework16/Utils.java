package ru.otus.java.basic.homework16;

import java.util.ArrayList;

public class Utils {
    /**
     * Получение случайного числа в заданном диапазоне
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return int
     */
    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    /**
     * Получение среднего значения целочисленного массива
     * @param marks целочисленный массив
     * @return int
     */
    public static int calculateAverage(ArrayList<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Integer mark : marks) {
            sum += mark;
        }

        return (int) sum / marks.size();
    }
}
