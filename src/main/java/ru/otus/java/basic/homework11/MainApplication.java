package ru.otus.java.basic.homework11;

import ru.otus.java.basic.homework11.animals.Animal;
import ru.otus.java.basic.homework11.animals.Cat;
import ru.otus.java.basic.homework11.animals.Dog;
import ru.otus.java.basic.homework11.animals.Horse;
import ru.otus.java.basic.homework11.mock.MockData;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("== Домашнее задание по лекции №11 ==");
        System.out.println("====================================");

        Cat cat = new Cat(MockData.getRandomName(), 1, -1, 100);
        Dog dog = new Dog(MockData.getRandomName(), 1, 2, 100);
        Horse horse = new Horse(MockData.getRandomName(), 1, 4, 100);

        Scanner scanner = new Scanner(System.in);

        int command = 0;
        do {
            System.out.println("----\nПожалуйста выберите что вы хотите сделать: \n" +
                    "1. Вывести информацию о животных\n" +
                    "2. Устроить бега\n" +
                    "3. Устроить заплыв\n" +
                    "4. Дать животным отдохнуть (обнулить усталость)\n" +
                    "5. Выйти");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    getAnimalsInfo(cat, dog, horse);
                    break;
                case 2:
                    runAnimals(cat, dog, horse);
                    break;
                case 3:
                    swimAnimals(cat, dog, horse);
                    break;
                case 4:
                    resetAnimalEndurance(cat, dog, horse);
                    break;
            }
        } while (command != 5);
    }

    /**
     * Метод восстанавливает endurance на начальное значение.
     * @param animals объекты с животными через запятую.
     */
    private static void resetAnimalEndurance(Animal... animals) {
        for (Animal animal : animals) {
            System.out.println("\"" + animal.getName() + "\" восстановил силы.");
            animal.resetStatus();
        }
    }

    /**
     * Метод рассчитывает время бега на указанную дистанцию. При перемещении тратиться endurance.
     * @param animals объекты с животными через запятую.
     */
    private static void runAnimals(Animal ... animals) {
        Scanner scanner = new Scanner(System.in);
        int distance = 0;
        System.out.println("----");
        System.out.println("Введите дистанцию (больше нуля):");
        do {
            distance = scanner.nextInt();
        } while (distance <= 0);

        for (Animal animal : animals) {
            int runDistance = animal.run(distance);
            String status = animal.isTired() ? "Устал" : "";
            if (runDistance < 0) {
                System.out.println(animal.getType() + " \"" + animal.getName() + "\" не смог пройти дистанцию. " + status);
                continue;
            }
            System.out.println(animal.getType() + " \"" + animal.getName() + "\" пробежал дистанцию за " + runDistance);
        }
    }

    /**
     * Метод рассчитывает время бега на указанную дистанцию. При перемещении тратиться endurance.
     * @param animals объекты с животными через запятую.
     */
    private static void swimAnimals(Animal ... animals) {
        Scanner scanner = new Scanner(System.in);
        int distance = 0;
        System.out.println("----");
        System.out.println("Введите дистанцию (больше нуля):");
        do {
            distance = scanner.nextInt();
        } while (distance <= 0);

        for (Animal animal : animals) {
            int runDistance = animal.swim(distance);
            String status = animal.isTired() ? "Устало" : "";
            if (runDistance < 0) {
                System.out.println(animal.getType() + " \"" + animal.getName() + "\" не смог проплыть дистанцию. " + status);
                continue;
            }
            System.out.println(animal.getType() + " \"" + animal.getName() + "\" проплыл дистанцию за " + runDistance);
        }
    }

    /**
     * Метод выводит в консоль информацию о животных.
     * @param animals объекты с животными через запятую.
     */
    private static void getAnimalsInfo(Animal ... animals) {
        System.out.println("----");
        for (Animal animal : animals) {
            animal.info();
        }
    }
}
