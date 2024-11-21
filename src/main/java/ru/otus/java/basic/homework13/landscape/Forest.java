package ru.otus.java.basic.homework13.landscape;

import ru.otus.java.basic.homework13.interfaces.Landscape;
import ru.otus.java.basic.homework13.interfaces.Particant;

public class Forest implements Landscape {
    private int length;
    final Terrain terrain = Terrain.DENSE_FOREST;

    public Forest(int length) {
        this.length = length;
    }

    @Override
    public boolean move(Particant participant) {
        return participant.move(length, terrain);
    }

    @Override
    public void getInfo() {
        System.out.println(terrain.getName() + " - " + length + " км.");
    }

    @Override
    public Terrain getTerrain() {
        return terrain;
    }
}
