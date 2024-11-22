package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.Human;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Location;

import java.util.Arrays;

public class Car implements Transport {
    private String name;
    private int fuel;
    private int maxFuel;
    private boolean isActive;
    private Location[] closedLocation;
    private Human driver;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Машина \"" + name + "\" | Топливо: " + fuel + "/" + maxFuel + " | Труднопроходимый ландшафт: " + Arrays.toString(closedLocation) + "| Можно использовать: " + isActive);
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
    public void getOn(Human driver) {
        this.driver = driver;
    }

    @Override
    public void getOff() {
        driver = null;
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.CAR;
    }

    public Car(String name, int fuel) {
        this.name = name;
        this.fuel = fuel;
        maxFuel = fuel;
        isActive = true;
        closedLocation = new Location[] {
                Location.DENSE_FOREST,
                Location.SWAMP
        };
    }
}
