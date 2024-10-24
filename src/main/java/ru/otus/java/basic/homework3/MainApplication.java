package ru.otus.java.basic.homework3;

import ru.otus.java.basic.homework3.AppUtils;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        final int MIN_INT_VALUE = -9;
        final int MAX_INT_VALUE = 9;
        final int MIN_ARR_SIZE = 2;
        final int MAX_ARR_SIZE = 6;

        int[][] generatedArray;
        int arraySizeVertical;
        int arraySizeHorizontal;

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Домашнее задание. Лекция №7 ============================");
        System.out.println("=== (!) все значения в задания генерируются автоматически ====");
        System.out.println("=== (!) Для каждого задания генерируется новый массив     ====");
        int command;
        do {
            System.out.println("==============================================================\n"+
                    "Выберите задачу: \n" +
                    "1 - Вычислить сумму значений элементов больше нуля двумерного массива;\n" +
                    "2 - Печатать в консоль квадрата из символов * со сторонами соответствующей длины\n" +
                    "3 - Обнуление диагонали двумерного массива\n" +
                    "4 - Поиск максимального элемента в двумерном массиве\n" +
                    "5 - Сумма элементов второй строки\n" +
                    "6 - Выйти");
            command = scanner.nextInt();
            arraySizeVertical = AppUtils.getRandomInt(MIN_ARR_SIZE + 1, MAX_ARR_SIZE);
            arraySizeHorizontal = AppUtils.getRandomInt(MIN_ARR_SIZE + 1, MAX_ARR_SIZE);
            switch (command) {
                case 1:
                    int sumOfPositiveElements = 0;
                    generatedArray = new int[arraySizeVertical][arraySizeHorizontal];
                    AppUtils.fillArrayRandomValues(generatedArray, MIN_INT_VALUE, MAX_INT_VALUE);
                    System.out.println("Сгенерированный массив:");
                    AppUtils.printArrayInConsole(generatedArray);
                    sumOfPositiveElements = sumOfPositiveElements(generatedArray);
                    System.out.println("Сумма всех положительных элементов массива = " + sumOfPositiveElements);
                    break;
                case 2:
                    int squareSize = 0;
                    do {
                        System.out.println("Введите размер квадрата (от 2 до 10):");
                        squareSize = scanner.nextInt();
                        if (squareSize >= 2 && squareSize <= 10) {
                            break;
                        }
                    } while(true);
                    consolePrintSquare(squareSize);
                    break;
                case 3:
                    int diagonalVector = 0;
                    generatedArray = new int[arraySizeVertical][arraySizeHorizontal];
                    AppUtils.fillArrayRandomValues(generatedArray, MIN_INT_VALUE, MAX_INT_VALUE);
                    System.out.println("Сгенерированный массив:");
                    AppUtils.printArrayInConsole(generatedArray);
                    do {
                        System.out.println("Выберите диагональ для обнуления (1 - левая, 2 - правая, 3 - обе):");
                        diagonalVector = scanner.nextInt();
                        if (diagonalVector >= 1 && diagonalVector <= 3) {
                            break;
                        }
                    } while(true);
                    diagonalElementsZero(generatedArray, diagonalVector);
                    System.out.println("Новый массив");
                    AppUtils.printArrayInConsole(generatedArray);
                    break;
                case 4:
                    int maxElement = 0;
                    generatedArray = new int[arraySizeVertical][arraySizeHorizontal];
                    AppUtils.fillArrayRandomValues(generatedArray, MIN_INT_VALUE, MAX_INT_VALUE);
                    System.out.println("Сгенерированный массив:");
                    AppUtils.printArrayInConsole(generatedArray);
                    maxElement = findMax(generatedArray);
                    System.out.println("Максимальный элемент в массиве: " + maxElement);
                    break;
                case 5:
                    int sum = 0;
                    generatedArray = new int[arraySizeVertical][arraySizeHorizontal];
                    AppUtils.fillArrayRandomValues(generatedArray, MIN_INT_VALUE, MAX_INT_VALUE);
                    System.out.println("Сгенерированный массив:");
                    AppUtils.printArrayInConsole(generatedArray);
                    sum = getSumSecondRow(generatedArray);
                    System.out.println("Сумма элементов = " + sum);
                    break;
                default:
                    break;
            }
        } while (command != 6);
    }

    /**
     * Метод вычисляющий сумму всех положительных элементов массива
     * @param arr ссылка на целочисленный двумерный массив
     * @return int
     */
    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += Math.max(arr[i][j], 0);
            }
        }
        return sum;
    }

    /**
     * Метод печатающий в консоль квадрат из символов *
     * @param squareSize - размер квадрата
     */
    public static void consolePrintSquare(int squareSize) {
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    /**
     * Метод обнуляющий одну из диагоналей массива
     * @param arr ссылка на целочисленный двумерный массив
     * @param diagonal направление диагонали (1 - левая, 2 - правая, 3 - обе)
     */
    public static void diagonalElementsZero(int[][] arr, int diagonal) {
        int leftIndex = 0;
        int rightIndex = arr[0].length-1;
        int checkedSize = Math.min(arr.length, arr[0].length);
        switch (diagonal) {
            case 1:
                for (int i = 0; i < checkedSize; i++) {
                    arr[i][leftIndex] = 0;
                    leftIndex++;
                }
                break;
            case 2:
                for (int i = 0; i < checkedSize; i++) {
                    arr[i][rightIndex] = 0;
                    rightIndex--;
                }
                break;
            case 3:
                for (int i = 0; i < checkedSize; i++) {
                    arr[i][leftIndex] = 0;
                    arr[i][rightIndex] = 0;
                    leftIndex++;
                    rightIndex--;
                }
                break;
            default:
                break;
        }
    }

    /**
     * Метод находит максимальный элемент в двумерном массиве
     * @param arr - ссылка на двумерный целочисленный массив
     * @return int
     */
    public static int findMax(int[][] arr) {
        int maxResult = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                maxResult = Math.max(maxResult, arr[i][j]);
            }
        }
        return maxResult;
    }

    /**
     * Метод вычисляет сумму элементов второй строки. Если 2-й строки нет возвращает -1
     * @param arr ссылка на целочисленный двумерный массив
     * @return int
     */
    public static int getSumSecondRow(int[][] arr) {
        int sum = 0;
        if (arr.length < 2) {
            return -1;
        }
        for (int i = 0; i < arr[1].length; i++) {
            sum += arr[1][i];
        }
        return sum;
    }
}
