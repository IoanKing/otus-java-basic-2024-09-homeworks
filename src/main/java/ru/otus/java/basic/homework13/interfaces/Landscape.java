package ru.otus.java.basic.homework13.interfaces;

import ru.otus.java.basic.homework13.landscape.Terrain;

public interface Landscape {
    boolean move(Particant participant);
    void getInfo();
    Terrain getTerrain();
}
