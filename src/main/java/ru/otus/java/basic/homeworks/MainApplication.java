package ru.otus.java.basic.homeworks;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод: 1 - greetings; 2 - checkSign; 3 - selectColor; 4 - compareNumbers; 5 - addOrSubtractAndPrint");
        int selectedMethod = scanner.nextInt();
        switch (selectedMethod) {
            case 1:
                greetings();
                break;
            case 2:
                checkSign(1,2,-4);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            default:
                addOrSubtractAndPrint(1,2,false);
                break;
        }
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 21;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result;
        if (increment) {
            result = initValue + delta;
        } else {
            result = initValue - delta;
        }
        System.out.println(result);
    }
}
