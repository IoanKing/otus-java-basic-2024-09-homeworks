package ru.otus.java.basic.homework19.PersonDataBase;

import java.util.Random;

public enum Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;

    private static final Position[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Position getRandom() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
