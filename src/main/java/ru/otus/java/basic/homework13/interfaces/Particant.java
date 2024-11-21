package ru.otus.java.basic.homework13.interfaces;

import ru.otus.java.basic.homework13.landscape.Terrain;

public interface Particant {
    String getName();
    boolean enterTransport(Transport transport);
    boolean outTransport();
    boolean move(int distance, Terrain terrain);
}
