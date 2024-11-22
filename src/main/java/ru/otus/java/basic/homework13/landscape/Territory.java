package ru.otus.java.basic.homework13.landscape;

import ru.otus.java.basic.homework13.interfaces.Landscape;
import ru.otus.java.basic.homework13.interfaces.Traveler;

public class Territory implements Landscape {
    private final Location location;
    private final int length;

    public int getLength() {
        return length;
    }

    public void getInfo() {
        System.out.println(location + " " + length + " км");
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean crossing(int distance, Traveler traveler) {
        return traveler.move(distance, location);
    }

    @Override
    public String getName() {
        return location.toString();
    }

    public Territory(Location location, int length) {
        this.location = location;
        this.length = length;
    }
}
