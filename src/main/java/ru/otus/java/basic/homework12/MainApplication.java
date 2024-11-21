package ru.otus.java.basic.homework12;

import ru.otus.java.basic.homework12.Utils.Util;
import ru.otus.java.basic.homework12.animals.Cat;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("== Домашнее задание по лекции №12 ==");

        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20)),
                new Cat(Util.getRandomName(), Util.getRandomInt(5, 20))
        };

        Scanner scanner = new Scanner(System.in);
        int command = 0;

        do {
            System.out.println("====================================\n" +
                    "Пожалуйста выберите что вы хотите сделать: \n" +
                    "1. Вывести информацию о котах\n" +
                    "2. Список голодных котов\n" +
                    "3. Покормить котов\n" +
                    "4. Подождать пока все коты будут голодными\n" +
                    "5. Проверить наполнение тарелки\n" +
                    "6. Наполнить тарелку\n" +
                    "7. Выйти");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    getCatsInfo(cats);
                    break;
                case 2:
                    getHangryCats(cats);
                    break;
                case 3:
                    catEating(cats, plate);
                    break;
                case 4:
                    resetCatsHungry(cats);
                    break;
                case 5:
                    checkPlate(plate);
                    break;
                case 6:
                    addPlateItem(plate);
                    break;
            }
        } while (command != 7);
    }

    private static void getHangryCats(Cat[] cats) {
        for (Cat cat: cats) {
            if (cat.isHungry())
                System.out.println(cat);
        }
    }

    private static void resetCatsHungry(Cat[] cats) {
        for (Cat cat: cats) {
            cat.setHungry();
        }
    }

    private static void addPlateItem(Plate plate) {
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        do {
            System.out.println("Сколько еды положить в тарелку? (больше 0)");
            command = scanner.nextInt();
            plate.addItems(command);
        } while (command <= 0);
    }

    private static void catEating(Cat[] cats, Plate plate) {
        for (Cat cat: cats) {
            boolean hungryStatus = cat.isHungry();
            boolean eatingStatus = cat.eating(plate);
            if (hungryStatus ^ eatingStatus) {
                System.out.println(cat.getName() + " покушал.");
            }
        }
        System.out.println("В тарелке осталось " + plate.getFilling() + " единиц еды.");
    }

    private static void checkPlate(Plate plate) {
        int plateFilling = plate.getFilling();
        System.out.println("В тарелке " + plateFilling + " единиц еды.");
    }

    private static void getCatsInfo(Cat[] cats) {
        for (Cat cat: cats) {
            cat.getInfo();
        }
    }
}
