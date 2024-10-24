package ru.otus.java.basic.homework10;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("== Домашнее задание по лекции №10 ==");
        System.out.println("====================================");
        int command = 0;
        do {
            System.out.println("----\nПожалуйста выберите что вы хотите сделать: \n" +
                    "1. Запустить задание c классом User\n" +
                    "2. Запустить задание с классом Box\n" +
                    "3. Выйти");
            command = scaner.nextInt();
            switch (command) {
                case 1:
                    runUsersTask();
                    break;
                case 2:
                    runBoxTask();
                    break;
                default:
                    break;
            }
        } while (command != 3);
    }

    public static void runUsersTask() {
        Scanner scaner = new Scanner(System.in);
        User[] users = new User[10];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
        }
        int command = 0;
        do {
            System.out.println("----\nЧто вы хотите сделать с пользователями: \n" +
                    "1. Вывести список всех пользователей\n" +
                    "2. Вывести информацию о пользователях старше 40 лет\n" +
                    "3. Вывести информацию о пользователе\n" +
                    "4. Выйти");
            command = scaner.nextInt();
            switch (command) {
                case 1:
                    for (int i = 0; i < users.length; i++) {
                        System.out.println(i + ". " + users[i].getName() + " " + users[i].getSurname() + " (Возраст: " + users[i].getUserAge() + ")");
                    }
                    break;
                case 2:
                    for (int i = 0; i < users.length; i++) {
                        if (users[i].getUserAge() >= 40) {
                            users[i].getUserInfo();
                        }
                    }
                    break;
                case 3:
                    do {
                        System.out.println("Введите номер пользователя");
                        command = scaner.nextInt();
                        if (command >= 0 && command < users.length) {
                            users[command].getUserInfo();
                            break;
                        }
                    } while(command < 0 || command >= users.length);
                    break;
                default:
                    break;
            }
        } while (command != 4);
    }

    public static void runBoxTask() {
        Box exampleBox = new Box();
        Scanner scaner = new Scanner(System.in);
        int command = 0;
        do {
            System.out.println("----\nЧто вы хотите сделать с коробкой: \n" +
                    "1. Посмотреть сведения о коробке\n" +
                    "2. Открыть/закрыть коробку\n" +
                    "3. Изменить цвет коробки\n" +
                    "4. Положить вещь в коробку\n" +
                    "5. Вынуть вещь из коробки\n" +
                    "6. Выйти");
            command = scaner.nextInt();
            switch (command) {
                case 1:
                    exampleBox.getBoxInfo();
                    break;
                case 2:
                    exampleBox.setBoxClosedOrOpen();
                    break;
                case 3:
                    exampleBox.setBoxColor();
                    break;
                case 4:
                    exampleBox.putItemInBox();
                    break;
                case 5:
                    exampleBox.takeOfItemInBox();
                    break;
                default:
                    break;
            }
        } while (command != 6);
    }
}
