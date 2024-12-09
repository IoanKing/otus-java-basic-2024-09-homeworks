package ru.otus.java.basic.homework19;

public enum Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;

    public static Position getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}