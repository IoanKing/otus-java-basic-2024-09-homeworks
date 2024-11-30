package ru.otus.java.basic.homework13.interfaces;

import ru.otus.java.basic.homework13.landscape.Location;

public interface Traveler {
    String getName();
    boolean move(int distance, Location location);
    void enterTransport(Transport transport);
    void outTransport();
    void rest();
}
