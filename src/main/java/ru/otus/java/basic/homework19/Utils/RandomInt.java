package ru.otus.java.basic.homework19.Utils;

public class RandomInt {
    /**
     * Получение случайного числа в заданном диапазоне
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return int
     */
    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
