package ru.otus.java.basic.homework10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Box {
    private int size;
    private String color;
    private boolean isOpen;
    private String [] items;

    private String[] COLORS = {
            "Red",
            "Blue",
            "Green",
            "Black",
            "Yellow",
            "Gray",
            "White"
    };

    public Box() {
        Random random = new Random();
        int MIN_BOX_SIZE = 2;
        int MAX_BOX_SIZE = 6;
        this.size = MockData.getRandomInt(MIN_BOX_SIZE, MAX_BOX_SIZE);
        this.color = COLORS[random.nextInt(COLORS.length)];
        this.isOpen = true;
        this.items = new String[size];
        Arrays.fill(this.items, null);
    }

    public void setBoxClosedOrOpen () {
        this.isOpen = !this.isOpen;
        if (this.isOpen) {
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка закрыта");
        }
    }

    public void setBoxColor () {
        Scanner scanner = new Scanner(System.in);
        int command;
        do {
            System.out.println("\nВыберите новый цвет коробки:");
            for (int i = 0; i < COLORS.length; i++) {
                System.out.println(i + ". " + COLORS[i]);
            }
            command = scanner.nextInt();
        } while (command < 0 && command >= COLORS.length);
        if (command >= 0 && command < COLORS.length) {
            this.color = COLORS[command];
            System.out.println("Цвет коробки изменён на " + this.color);
        } else {
            System.out.println("такого цвета нету");
        }
    }

    public void getBoxInfo() {
        System.out.println("\n----данные о коробке----");
        System.out.println("Размер: " + this.size + " | цвет: " + this.color + " | Открыта/закрыта: " + this.isOpen);
        System.out.print("Содержимое коробки\n[");
        for (int i = 0; i < this.items.length; i++) {
            System.out.print(this.items[i] + " ");
        }
        System.out.print("]\n------------------------");
    }

    public void putItemInBox () {
        Scanner scanner = new Scanner(System.in);
        String item = "";
        if (!this.isOpen) {
            System.out.println("Коробка закрыта.");
            return;
        }
        System.out.println("Какой предмет вы хотите положить в коробку?");
        item = scanner.nextLine();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = item;
                System.out.println("\"" + item + "\" помещён в коробку");
                return;
            }
        }
        System.out.println("Не получилось добавить \"" + item + "\" в коробку - нет места.");
    }

    public void takeOfItemInBox () {
        Scanner scanner = new Scanner(System.in);
        String item = "";
        if (!this.isOpen) {
            System.out.println("Коробка закрыта.");
            return;
        }
        System.out.print("Содержимое коробки\n[");
        for (int i = 0; i < this.items.length; i++) {
            System.out.print(this.items[i] + " ");
        }
        System.out.print("]\n");
        System.out.println("Какой предмет вы хотите вынуть из коробки?");
        item = scanner.nextLine();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].equals(item)) {
                    this.items[i] = null;
                    System.out.println("\"" + item + "\" вынут из коробки.");
                    return;
                }
            }
        }
        System.out.println("Данного предмета нет в коробке.");
    }
}
