package ru.otus.java.basic.homework19.Utils;

public class Measure {
    private static long time;

    public static void stamp() {
        time = System.currentTimeMillis();
    }

    public static void print() {
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time + " ms");
    }
}
