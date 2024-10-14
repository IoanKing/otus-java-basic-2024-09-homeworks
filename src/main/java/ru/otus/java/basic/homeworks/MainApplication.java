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
                checkSign(getRandomInt(-100, 100),getRandomInt(-100, 100),getRandomInt(-100, 100));
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            default:
                addOrSubtractAndPrint(getRandomInt(0, 10), getRandomInt(1, 10), getRandomBoolean());
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
            System.out.println("Сумма положительная [" + a + " + " + b + " + " + c + " = " + sum +"]");
        } else {
            System.out.println("Сумма отрицательная [" + a + " + " + b + " + " + c + " = " + sum + "]");
        }
    }

    public static void selectColor() {
        int data = getRandomInt(0, 30);
        if (data <= 10) {
            System.out.println("Красный [" + data + " <= 10]");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый [10 > " + data + " <= 20]");
        } else if (data > 20) {
            System.out.println("Зелёный [20 > " + data + "]");
        }
    }

    public static void compareNumbers() {
        int a = getRandomInt(-100, 100);
        int b = getRandomInt(-100, 100);
        if (a >= b) {
            System.out.println("a >= b [" + a + " >= " + b + "]");
        } else {
            System.out.println("a < b [" + a + " < " + b + "]");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println((initValue + delta) + " [" + initValue + " + " + delta + " | " + increment + "]");
        } else {
            System.out.println((initValue - delta) + " [" + initValue + " - " + delta + " | " + increment + "]");
        }
    }

    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }
}