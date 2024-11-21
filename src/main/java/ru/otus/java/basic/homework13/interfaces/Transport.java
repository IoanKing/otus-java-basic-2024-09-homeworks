package ru.otus.java.basic.homework13.interfaces;

import ru.otus.java.basic.homework13.landscape.Terrain;

public interface Transport {
    String getName();
    void getInfo();
    boolean canMove(Terrain terrain);
    boolean move(int distance, Terrain terrain);
    boolean isActive();
}
