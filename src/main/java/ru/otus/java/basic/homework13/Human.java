package ru.otus.java.basic.homework13;

import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.interfaces.Traveler;
import ru.otus.java.basic.homework13.landscape.Location;
import ru.otus.java.basic.homework13.transport.TransportType;

public class Human implements Traveler {
    private final String name;
    private Transport currentTransport;
    private int endurance;
    private final int maxEndurance;
    private boolean isRested;

    public String getName() {
        return name;
    }

    public void rest() {
        System.out.println("...путешественник отдохнул.");
        endurance = maxEndurance;
    }

    public void getInfo() {
        String transportName = "";
        if (currentTransport != null) {
            transportName = currentTransport.getName();
        }
        System.out.println("Человек \"" + name + "\" | Выносливость: " + endurance + "/" + maxEndurance + " | Транспорт: " + transportName);
    }

    public boolean move(int distance, Location location) {
        if (currentTransport != null) {
            if (currentTransport.canMove(location)) {
                return currentTransport.move(distance, location);
            }
            return false;
        }
        return walk(distance, location);
    }

    public boolean walk(int distance, Location location) {
        if (location == Location.ROADSIDE_HOTEL) {
            rest();
        }
        if (!isRested) return false;
        endurance = Math.max(endurance - distance, -1);
        if (endurance < 0) {
            System.out.println("..." + name + " не смог преодолеть дистанцию. Устал.");
            return false;
        }
        System.out.println("..." + name + " преодолел дистанцию дистанцию.");
        if (endurance <= 0) {
            System.out.println("..." + name + " устал.");
            isRested = false;
        }
        return true;
    }

    public boolean runBicycle(int distance, Location location) {
        if (location == Location.ROADSIDE_HOTEL) {
            rest();
        }
        if (!isRested) return false;
        endurance = Math.max(endurance - distance, -1);
        if (endurance < 0) {
            System.out.println("..." + name + " не смог преодолеть дистанцию. Устал.");
            outTransport();
            return false;
        }
        System.out.println("..." + name + " преодолел дистанцию дистанцию.");
        if (endurance <= 0) {
            System.out.println("..." + name + " устал.");
            outTransport();
            isRested = false;
        }
        return true;
    }

    public boolean isActive() {
        return isRested;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    @Override
    public void enterTransport(Transport transport) {
        if (transport.isActive()) {
            currentTransport = transport;
            currentTransport.getOn(this);
            System.out.println("├--" + name + " сел в транспорт: " + currentTransport.getName());
            return;
        }
        System.out.println("├--" + name + " не получилось сесть в транспорт: " + currentTransport.getName());
    }

    @Override
    public void outTransport() {
        currentTransport.getOff();
        currentTransport = null;
        System.out.println("..." + name + " покинул транспорт.");
    }

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
        maxEndurance = endurance;
        currentTransport = null;
        isRested = true;
    }

}
