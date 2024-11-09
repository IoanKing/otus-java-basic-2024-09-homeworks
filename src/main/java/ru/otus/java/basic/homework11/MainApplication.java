package ru.otus.java.basic.homework11;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("== Домашнее задание по лекции №11 ==");
        System.out.println("====================================");
        Cat cat = new Cat(MockData.getRandomName());
        Dog dog = new Dog(MockData.getRandomName());
        Horse horse = new Horse(MockData.getRandomName());

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
                    movementAnimals(true, cat, dog, horse);
                    break;
                case 3:
                    movementAnimals(false, cat, dog, horse);
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
    private static void resetAnimalEndurance(Animal ... animals) {
        for (Animal animal : animals) {
            System.out.println("\"" + animal.getName() + "\" восстановил силы.");
            animal.resetStatus();
        }
    }

    /**
     * Метод рассчитывает время перемещения на указанную дистанцию. При перемещении тратиться endurance.
     * @param isRun тип перемещения (true - бег, false - плаванье)
     * @param animals объекты с животными через запятую.
     */
    private static void movementAnimals(boolean isRun, Animal ... animals) {
        Scanner scanner = new Scanner(System.in);
        int distance = 0;
        int time = 0;
        String[][] MOVEMENT_TEXT = {
                {"бега", "бегать", "пробежать", "пробежало"},
                {"плавания", "плавать", "проплыть", "проплыло"},
        };
        int textIndex = isRun ? 0 : 1;
        do {
            System.out.println("\nВведите дистанцию "  + MOVEMENT_TEXT[textIndex][0] + " (от 0 до 10):");
            distance = scanner.nextInt();

            if (distance >= 0 && distance <= 10) {
                for (Animal animal : animals) {
                    if (isRun) {
                        if (!animal.isCanRun()) {
                            System.out.println(animal.getType() + " \"" + animal.getName() + "\" не умеет " + MOVEMENT_TEXT[textIndex][1] + ".");
                            continue;
                        }
                        time = animal.run(distance);
                        System.out.print(animal.getType() + " \"" + animal.getName() + "\" ");
                        if (time < 0) {
                            System.out.println(" не смогло "+ MOVEMENT_TEXT[textIndex][2] + " дистанцию. Устало.");
                            continue;
                        }
                        System.out.println(MOVEMENT_TEXT[textIndex][3] + " " + distance + " метров за " + time + " секунд.");
                    } else {
                        if (!animal.isCanSwim()) {
                            System.out.println(animal.getType() + " \"" + animal.getName() + "\" не умеет " + MOVEMENT_TEXT[textIndex][1] + ".");
                            continue;
                        }
                        time = animal.swim(distance);
                        System.out.print(animal.getType() + " \"" + animal.getName() + "\" ");
                        if (time < 0) {
                            System.out.println(" не смогло "+ MOVEMENT_TEXT[textIndex][2] + " дистанцию. Устало.");
                            continue;
                        }
                        System.out.println(MOVEMENT_TEXT[textIndex][3] + " " + distance + "метров за " + time + " секунд.");
                    }
                }
            }
        } while (distance < 0 || distance > 10);
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
