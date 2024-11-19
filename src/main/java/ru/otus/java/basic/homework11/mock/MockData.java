package ru.otus.java.basic.homework11.mock;

import java.util.Random;

public class MockData {
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
}
