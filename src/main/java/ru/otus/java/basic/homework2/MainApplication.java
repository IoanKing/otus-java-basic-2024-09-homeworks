package ru.otus.java.basic.homework2;

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
                "4 - Увеличение каждого элемента массива на указанное число\n" +
                "5 - Вывести в консоль сумма элементов какой из половин массива больше\n" +
                "6 - (+) Сформировать новый массив как сумму нескольких других\n" +
                "7 - (+) Проверка, что в массиве есть точка, где сумма элементов левой части от точки равна сумме элементов справа от точки\n" +
                "8 - (+) Проверка, что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)\n" +
                "9 - (+) Перевернуть массив");
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
                getArrayRandomValues(arr, MIN_INT_VALUE, MAX_INT_VALUE);
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
            case 6:
                //не придумал как сгенерировать и потом передать несколько массивов - оставил как в ДЗ
                int[] array1 = {1, 2, 3};
                int[] array2 = {2, 2};
                int[] array3 = {1, 1, 1, 1, 1};
                int[] arraySum;
                System.out.println("Задание: Сформировать новый массив как сумму элементов других нескольких массивов");
                System.out.println("Исходный массив 1: " + Arrays.toString(array1));
                System.out.println("Исходный массив 2: " + Arrays.toString(array2));
                System.out.println("Исходный массив 3: " + Arrays.toString(array3));
                arraySum = sumSeveralArrays(array1, array2, array3);
                System.out.println("Результат:" + Arrays.toString(arraySum));
                break;
            case 7:
                int[] checkedArray = {5, 3, 4, -2};
                boolean isPointExists = false;
                System.out.println("Задание: Проверка, что в массиве есть точка, где сумма элементов левой части от точки равна сумме элементов справа от точки");
                System.out.println("Исходный массив: " + Arrays.toString(checkedArray));
                isPointExists = checkPointSumElementOfArray(checkedArray);
                if (isPointExists) {
                    System.out.println("Точка существует");
                } else {
                    System.out.println("точка НЕ существует");
                }
                break;
            case 8:
                int[] checkedArray2 = {6, 5, 4, 3, 2, 1};
                boolean isArraySorted = false;
                System.out.println("Задание: Проверка, что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)");
                System.out.println("Исходный массив: " + Arrays.toString(checkedArray2));
                isArraySorted = checkSortArray(checkedArray2);
                if (isArraySorted) {
                    System.out.println("Массив отсортирован");
                } else {
                    System.out.println("Массив НЕ отсортирован");
                }
                break;
            case 9:
                arr = new int[MIN_ARR_SIZE];
                getArrayRandomValues(arr, MIN_INT_VALUE, MAX_INT_VALUE);
                System.out.println("Задание: Перевернуть массив");
                System.out.println("Исходный массив: " + Arrays.toString(arr));
                arrayReverse(arr);
                System.out.println(Arrays.toString(arr));
                break;
            default:
                break;
        }
    }

    /**
     * Метод печатающий в консоль строку указанное количество раз
     * @param count - количество повторений
     * @param str - строка для печати
     */
    public static void arrayPrintNTimes(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " - " + str);
        }
    }

    /**
     * Метод суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль
     * @param arr - ссылка на обрабатываемый массив
     */
    public static void sumArrayElementsMoreFive(int[] arr) {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                summ += arr[i];
            }
        }
        System.out.println(summ);
    }

    /**
     * Метод заполняющий каждую ячейку массива указанным числом
     * @param fillNumber - число заполнитель
     * @param arr - ссылка на обрабатываемый массив
     */
    public static void fillArrayBySelectedNumber(int fillNumber, int[] arr) {
        Arrays.fill(arr, fillNumber);
    }

    /**
     * Метод увеличивающий значение каждой ячейки на указанное число
     * @param incNumber - число на которое требуется увеличить элементы массива
     * @param arr - ссылка на обрабатываемый массив
     */
    public static void incArrayElementsBySelectedNumber(int incNumber, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += incNumber;
        }
    }

    /**
     * Метод печатающий в консоль сумма элементов какой из половин массива больше.
     * @param arr - ссылка на обрабатываемый массив
     */
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

    /**
     * Метод суммирующий несколько массивов
     * @param arrays - ссылки на массивы через запятую
     * @return int[] - сумма массивов
     */
    public static int[] sumSeveralArrays(int[] ...arrays) {
        //по хорошему нужно добавить исключение - проверку на количество переданных массивов больше 1
        //но будем считать что по условиям ДЗ в метод всегда передаётся больше 2 массивов
        int[] sumArrays = Arrays.copyOf(arrays[0], arrays[0].length);
        for (int i = 1; i < arrays.length ; i++) {
            sumArrays = arraySum(sumArrays, arrays[i]);
        }
        return sumArrays;
    }

    /**
     * Метод проверяющий, что в массиве есть точка, где сумма элементов левой части от точки равна сумме элементов справа от точки
     * @param arr - ссылка на массив
     * @return isPointExist - true/false
     */
    public static boolean checkPointSumElementOfArray(int[] arr) {
        boolean isPointExist = false;
        for (int i = 1; i < arr.length; i++) {
            System.out.println("Сравнение: " + sumArrayElements(arr, 0, i) + " и " + sumArrayElements(arr, i, arr.length));
            if (sumArrayElements(arr, 0, i) == sumArrayElements(arr, i, arr.length)) {
                isPointExist = true;
                break;
            }
        }
        return isPointExist;
    }

    /**
     * Метод проверяющий, что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)
     * @param arr - ссылка на массив
     * @return isSorted
     */
    public static boolean checkSortArray(int[] arr) {
        boolean isSelectSortType = false;
        Scanner scanner = new Scanner(System.in);
        int selectedMethod = 0;
        do {
            System.out.println("Выберите сортировку 1 - по возрастанию, 2 - по убыванию");
            selectedMethod = scanner.nextInt();
            if (selectedMethod == 1 || selectedMethod == 2) {
                isSelectSortType = true;
            }
        } while (!isSelectSortType);
        if (selectedMethod == 1) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] >= arr[i+1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] <= arr[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Метод, “переворачивающий” входящий массив
     * @param arr - ссылка на массив
     */
    public static void arrayReverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    //Вспомогательные методы

    /**
     * Метод заполняющий массив случайными числами
     * @param arr - ссылка на обрабатываемый массив
     * @param minValue - нижняя граница диапазона случайного числа
     * @param maxValue - верхняя граница диапазона случайного числа
     */
    public static void getArrayRandomValues (int[] arr, int minValue, int maxValue) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomInt(minValue, maxValue);
        }
    }

    /**
     * Метод складывающий элементы массива в заданном диапазоне индекса
     * @param arr - ссылка на обрабатываемый массив
     * @param startIndex - начальный индекс массива
     * @param endIndex - конечный индекс массива
     * @return (int) - Сумма элементов в заданном диапазоне индексов массива
     */
    public static int sumArrayElements(int[] arr, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Метод суммирующий элементы двух массивов
     * @param arr1 - ссылка на массив №1
     * @param arr2 - ссылка на массив №2
     * @return int[] - новый массив с суммой элементов массива №1 и массива №2
     */
    public static int[] arraySum(int[] arr1, int[] arr2) {
        int[] sum = new int[Math.max(arr1.length, arr2.length)];
        boolean isFirstArrayBigger = false;
        if (arr1.length >= arr2.length) {
            isFirstArrayBigger = true;
        }
        if (isFirstArrayBigger) {
            sum = Arrays.copyOf(arr1, arr1.length);
            for (int i = 0; i < arr2.length; i++) {
                sum[i] += arr2[i];
            }
        } else {
            sum = Arrays.copyOf(arr2, arr2.length);
            for (int i = 0; i < arr1.length; i++) {
                sum[i] += arr1[i];
            }
        }
        return sum;
    }

    /**
     * Метод генерирующий случайное целое число в заданном диапазоне
     * @param min - нижняя граница диапазона
     * @param max - верхняя граница диапазона
     * @return (int) - случайное число внутри указанного диапазона
     */
    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
