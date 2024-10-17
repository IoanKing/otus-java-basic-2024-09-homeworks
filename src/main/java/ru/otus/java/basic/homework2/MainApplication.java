package ru.otus.java.basic.homework2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        final int MIN_INT_VALUE = -10;
        final int MAX_INT_VALUE = 10;
        final int MIN_ARR_SIZE = 6;
        final int MAX_ARR_SIZE = 15;

        int[] arr;

        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Домашнее задание. Лекция №5 ======");
        System.out.println("(!) Все значения в методах генерируются случайным образом");
        System.out.println("========================================");
        System.out.println("Выберите метод: \n" +
                "1 - Распечатать строку \"Method\" n раз;\n" +
                "2 - Сумма всех элементов, значение которых больше 5\n" +
                "3 - Заполнение всех элементов массива указанным числом\n" +
                "4 - Увеличение каждого элемента массива на указаное число\n" +
                "5 - Вывести в консоль сумма элементов какой из половин массива больше");
        int selectedMethod = scanner.nextInt();

        switch (selectedMethod) {
            case 1:
                String printStr = "Method";
                int printCount = getRandomInt(0, MAX_INT_VALUE);
                System.out.println("Задание: Распечатать строку \"" +  printStr + "\" " + printCount + " раз.");
                arrayPrintNTimes(printCount, printStr);
                break;
            case 2:
                arr = new int[MIN_ARR_SIZE];
                System.out.println("Задание: Сумма всех элементов, значение которых больше 5");
                System.out.println("Массив: " + Arrays.toString(arr));
                getArrayRandomValues(arr, 2, MAX_INT_VALUE);
                sumArrayElementsMoreFive(arr);
                break;
            case 3:
                arr = new int[MIN_ARR_SIZE];
                int elementCount = getRandomInt(MIN_INT_VALUE, MAX_INT_VALUE);
                System.out.println("Задание: Заполнить каждую ячейку массива[" + arr.length + "] числом \"" + elementCount + "\"");
                System.out.println("Исходный массив: " + Arrays.toString(arr));
                fillArrayBySelectedNumber(elementCount, arr);
                System.out.println(Arrays.toString(arr));
                break;
            case 4:
                arr = new int[MIN_ARR_SIZE];
                getArrayRandomValues(arr, MIN_INT_VALUE, MAX_INT_VALUE);
                int incNumber = getRandomInt(MIN_INT_VALUE, MAX_INT_VALUE);
                System.out.println("Задание: Увеличить каждый элемент массива[" + arr.length + "] на число \"" + incNumber + "\"");
                System.out.println("Исходный массив: " + Arrays.toString(arr));
                incArrayElementsBySelectedNumber(incNumber, arr);
                System.out.println(Arrays.toString(arr));
                break;
            case 5:
                arr = new int[MIN_ARR_SIZE];
                getArrayRandomValues(arr, MIN_INT_VALUE, MAX_INT_VALUE);
                System.out.println("Задание: Печать в консоль сумма элементов какой из половин массива больше");
                System.out.println("Исходный массив: " + Arrays.toString(arr));
                halfSumArrayElementGreater(arr);
                break;
            default:
                break;
        }
    }

    //Метод печатающий в консоль строку указанное количество раз
    public static void arrayPrintNTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " - " + str);
        }
    }

    //Метод суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль
    public static void sumArrayElementsMoreFive(int[] checkedArray) {
        int summ = 0;
        for (int i = 0; i < checkedArray.length; i++) {
            if (checkedArray[i] > 5) {
                summ += checkedArray[i];
            }
        }
        System.out.println(summ);
    }

    //Метод заполняющий каждую ячейку массива указанным числом
    public static void fillArrayBySelectedNumber(int count, int[] arr) {
        Arrays.fill(arr, count);
    }

    //Метод увеличивающий значение каждой ячейки на указанное число
    public static void incArrayElementsBySelectedNumber(int incNumber, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += incNumber;
        }
    }

    //Метод печатающий в консоль сумма элементов какой из половин массива больше.
    public static void halfSumArrayElementGreater(int[] arr) {
        int arrayLeftSum = sumArrayElements(arr, 0,arr.length/2);
        int arrayRightSum = sumArrayElements(arr, arr.length/2,arr.length-1);
        if (arrayLeftSum == arrayRightSum) {
            System.out.println("Сумма каждой из половин массива одинакова: " + arrayLeftSum + " = " + arrayRightSum);
        } else if (arrayLeftSum > arrayRightSum) {
            System.out.println("Сумма левой части массива больше правой: " + arrayLeftSum + " > " + arrayRightSum);
        } else {
            System.out.println("Сумма левой части массива маньше правой: " + arrayLeftSum + " < " + arrayRightSum);
        }
    }

    //Вспомогательные методы

    //Метод заполняющий массив случайными числами
    public static void getArrayRandomValues (int[] arr, int minValue, int maxValue) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomInt(minValue, maxValue);
        }
    }

    //Метод складывающий элементы массива
    public static int sumArrayElements(int[] arr, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //Метод генерирующий случайное целое число в заданном диапазоне
    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
