package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.Human;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Location;

import java.util.Arrays;

public class Horse implements Transport {
    private String name;
    private int endurance;
    private int maxEndurance;
    private boolean isActive;
    private Location[] closedLocation;
    private Human driver;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Лошадь \"" + name + "\" | Выносливость: " + endurance + "/" + maxEndurance + " | Труднопроходимый ландшафт: " + Arrays.toString(closedLocation) + "| Можно использовать: " + isActive);
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
        if (location == Location.HAYFIELD) {
            endurance = maxEndurance;
            isActive = true;
            System.out.println("...лошадь накормлена.");
            return true;
        }
        endurance = Math.max(endurance - distance, -1);
        if (endurance < 0) {
            System.out.println("...Лошадь устала");
            System.out.println("...Не получилось преодолеть " + location.toString() + ".");
            return false;
        }
        System.out.println("..." + location.toString() + " преодолена.");
        if (endurance <= 0) {
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
        return TransportType.HORSE;
    }

    public Horse(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
        maxEndurance = endurance;
        isActive = true;
        closedLocation = new Location[] {
                Location.SWAMP
        };
    }
}
