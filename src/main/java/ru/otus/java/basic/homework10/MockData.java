package ru.otus.java.basic.homework10;

import java.time.Year;
import java.util.Random;

public class MockData {

    private static final String[] MAN_NAMES_LIST = {
            "Алексей",
            "Александр",
            "Анатолий",
            "Виктор",
            "Андрей",
            "Евгений",
            "Егор",
            "Николай",
            "Дмитрий",
            "Владимир"
    };

    private static final String[] WOMAN_NAMES_LIST = {
            "Александра",
            "Евгения",
            "Анастасия",
            "Светлана",
            "Василиса",
            "Виктория",
            "Оксана",
            "Елена",
            "Дарья",
            "Мария"
    };

    private static final String[] SURNAMES_LIST = {
            "Синицын",
            "Коршунов",
            "Гусев",
            "Куропаткин",
            "Соколов",
            "Воробьев",
            "Снегирев",
            "Рябчиков",
            "Филинов",
            "Сорокин"
    };

    private static final String[] MAN_PATRONYMIC_LIST = {
            "Алексеевич",
            "Александрович",
            "Анатольевич",
            "Викторович",
            "Андреевич",
            "Евгеньевич",
            "Егорович",
            "Николаевич",
            "Дмитриевич",
            "Владимирович"
    };

    private static final String[] WOMAN_PATRONYMIC_LIST = {
            "Алексеевна",
            "Александровна",
            "Анатольевна",
            "Викторовна",
            "Андреевна",
            "Евгеньевна",
            "Егоровна",
            "Николаевна",
            "Демитрьевна",
            "Владимировна"
    };

    private static final String[] EMAIL_PREFIX_LIST = {
            "invisible",
            "superpower",
            "flying",
            "immortal",
            "time_control",
            "traveller",
            "last_chance",
            "randomizer",
            "raining_man",
            "sunset"
    };

    private static final String[] EMAIL_DOMAIN_LIST = {
            "@mail.ru",
            "@gmail.com",
            "@rambler.ru",
            "@yandex.ru",
            "@yahoo.com"
    };

    private static final int MIN_BIRTH_YEAR = 1945;
    private static final int MAX_BIRTH_YEAR = 2010;

    public static String getRandomName (boolean isMan) {
        Random random = new Random();
        if (isMan) {
            return MAN_NAMES_LIST[random.nextInt(MAN_NAMES_LIST.length)];
        }
        return WOMAN_NAMES_LIST[random.nextInt(WOMAN_NAMES_LIST.length)];
    }

    public static String getRandomSurname (boolean isMan) {
        Random random = new Random();
        if (isMan) {
            return SURNAMES_LIST[random.nextInt(SURNAMES_LIST.length)];
        }
        return SURNAMES_LIST[random.nextInt(SURNAMES_LIST.length)] + "а";
    }

    public static String getRandomPatronymic (boolean isMan) {
        Random random = new Random();
        if (isMan) {
            return MAN_PATRONYMIC_LIST[random.nextInt(MAN_PATRONYMIC_LIST.length)];
        }
        return WOMAN_PATRONYMIC_LIST[random.nextInt(WOMAN_PATRONYMIC_LIST.length)];
    }

    public static int getRandomBirthDate () {
        return getRandomInt(MIN_BIRTH_YEAR, MAX_BIRTH_YEAR);
    }

    public static String getRandomEmail () {
        Random random = new Random();
        return EMAIL_PREFIX_LIST[random.nextInt(EMAIL_PREFIX_LIST.length)] + EMAIL_DOMAIN_LIST[random.nextInt(EMAIL_DOMAIN_LIST.length)];
    }

    public static boolean getRandomBoolean () {
        return Math.random() < 0.5;
    }

    public static int getRandomInt (int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
