package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.Human;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Location;

public class AllTerrainVehicle implements Transport {
    private final String name;
    private int fuel;
    private final int maxFuel;
    private boolean isActive;
    private Human driver;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Вездеход \"" + name + "\" | Топливо: " + fuel + "/" + maxFuel + " | Труднопроходимый ландшафт: нет | Можно использовать: " + isActive);
    }

    @Override
    public boolean canMove(Location location) {
        return true;
    }

    @Override
    public boolean move(int distance, Location location) {
        if (driver == null) return false;
        if (location == Location.FILLING_STANTION) {
            fuel = maxFuel;
            isActive = true;
            System.out.println("...машина заправлена");
            return true;
        }
        fuel = Math.max(fuel - distance, -1);
        if (fuel < 0) {
            System.out.println("...Топливо кончилось");
            System.out.println("...Не получилось преодолеть " + location.toString());
            return false;
        }
        System.out.println("..." + location.toString() + " преодолена.");
        if (fuel <= 0) {
            isActive = false;
        }
        return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void getOn(Human traveler) {
        driver = traveler;
    }

    @Override
    public void getOff() {
        driver = null;
    }

    public AllTerrainVehicle(String name, int fuel) {
        this.name = name;
        this.fuel = fuel;
        maxFuel = fuel;
        isActive = true;
    }
}
