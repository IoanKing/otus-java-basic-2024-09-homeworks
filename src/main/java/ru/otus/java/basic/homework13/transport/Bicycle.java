package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.Human;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Location;

import java.util.Arrays;

public class Bicycle implements Transport {
    private String name;
    private Location[] closedLocation;
    private boolean isActive;
    private Human driver;
    final static int enduranceCoefficient = 2;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Велосипед \"" + name + "\" | Труднопроходимый ландшафт: " + Arrays.toString(closedLocation));
    }

    @Override
    public boolean canMove(Location location) {
        for (Location landscape : closedLocation) {
            if (landscape == location) {
                System.out.println("...Транспорт не может двигаться по " + location.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean move(int distance, Location location) {
        if (driver == null) return false;
        if (location == Location.ROADSIDE_HOTEL) {
            driver.rest();
            return true;
        }
        isActive = driver.runBicycle((int) distance / enduranceCoefficient, location);
        return isActive;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void getOn(Human driver) {
        this.driver = driver;
        isActive = true;
    }

    @Override
    public void getOff() {
        driver = null;
        isActive = false;
    }

    public Bicycle(String name) {
        this.name = name;
        isActive = true;
        closedLocation = new Location[] {
                Location.SWAMP
        };
    }
}
