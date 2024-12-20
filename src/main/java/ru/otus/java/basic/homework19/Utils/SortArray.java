package ru.otus.java.basic.homework19.Utils;

import java.util.Arrays;

public class SortArray {
    /**
     * Метод печатающий массив в консоль.
     * @param array печатаемый массив
     */
    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * Метод сортирующий массив по методике Пузырька. Алгоритмическая сложность O(n^2).
     * @param array сортируемый массив.
     */
    public static void bubbleSort(int[] array) {
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needSort = true;
                }
            }
        } while (needSort);
    }

    /**
     * Метод выполняющий сортировку по методике Хоара для заданного диапазона массива. Алгоритмическая сложность O(n log n).
     * Аналог метода Array.sort в Java (тоже используется методика Хоара).
     * @param array сортируемый массив
     * @param leftBorder левый граничный элемент (начало массива)
     * @param rightBorder правый граничный элемент (конец массива)
     */
    public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
    }

    /**
     * Метод создающий массив заданного размера и заполняющий его случайными значениями в заданном диапазоне.
     * @param size размер массива
     * @param minValue минимальное значение диапазона
     * @param maxValue максимальное значение диапазона
     * @return сгенерированный массив целых чисел
     */
    public static int[] randomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomInt(minValue, maxValue);
        }
        return array;
    }

    /**
     * Метод возвращающий случайное целое число в заданном диапазоне.
     * @param min нижняя граница диапазона
     * @param max верхняя граница диапазона
     * @return сгенерированное число
     */
    private static int getRandomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    /**
     * Метод удаляющий дубликаты в массиве. В процессе проверки массив будет автоматически отсортирован.
     * @param array проверяемый массив
     * @return массив без дубликатов.
     */
    public static int[] removeDuplicates(int[] array) {
        Arrays.sort(array);
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[i - 1]) {
                array[k++] = array[i];
            }
        }
        return Arrays.copyOf(array, k);
    }
}
