package ru.otus.java.basic.homework12.Utils;

import java.util.Random;

public class Util {
    private static final String[] NAMES_LIST = {
            "Бах",
            "Бетховен",
            "Моцарт",
            "Шуберт",
            "Чайковский",
            "Штраус",
            "Шопен",
            "Вивальди",
            "Гендель",
            "Паганини",
            "Страдивари",
            "Тарковский",
            "Шарик",
            "Тузик",
            "Мурлыка",
            "Кошмарик",
            "Весельчак",
            "Барсик",
            "Тузик",
            "Лорд",
            "Барон",
            "Властелин",
    };

    /**
     * @return сгенерированное случайным образом имя животного.
     */
    public static String getRandomName () {
        Random random = new Random();
        return NAMES_LIST[random.nextInt(NAMES_LIST.length)];
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

