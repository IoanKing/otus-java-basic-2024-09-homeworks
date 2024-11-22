package ru.otus.java.basic.homework13.interfaces;

import ru.otus.java.basic.homework13.Human;
import ru.otus.java.basic.homework13.landscape.Location;

public interface Transport {
    String getName();
    void getInfo();
    boolean canMove(Location location);
    boolean move(int distance, Location location);
    boolean isActive();
    void getOn(Human driver);
    void getOff();
}
