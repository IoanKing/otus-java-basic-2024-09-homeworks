package ru.otus.java.basic.homework13;

import ru.otus.java.basic.homework13.interfaces.Particant;
import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Terrain;

public class Human implements Particant, Transport {
    private String name;
    private Transport currentTransport;
    private int endurance;
    private int maxEndurance;
    private boolean isActive;

    public String getName() {
        return name;
    }

    public void rest() {
        endurance = maxEndurance;
    }

    @Override
    public void getInfo() {
        String transportName = "";
        if (currentTransport != null) {
            transportName = currentTransport.getName();
        }
        System.out.println("Человек \"" + name + "\" | Выносливость: " + endurance + "/" + maxEndurance + " | Транспорт: " + transportName);
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return true;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (currentTransport != null) {
            return currentTransport.move(distance, terrain);
        }
        endurance = Math.max(endurance - distance, 0);
        if (endurance == 0) {
            isActive = false;
            System.out.println("...." + name + " не смог пройти дистанцию пешком.");
            return false;
        }
        System.out.println("...." + name + " прошёл дистанцию пешком.");
        return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    @Override
    public boolean enterTransport(Transport transport) {
        currentTransport = transport;
        if (currentTransport.isActive()) {
            System.out.println(".." + name + " сел в транспорт: " + currentTransport.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean outTransport() {
        if (currentTransport != null) {
            System.out.println(".." + name + " покинул транспорт: " + currentTransport.getName());
            currentTransport = null;
        }
        return true;
    }

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
        maxEndurance = endurance;
        currentTransport = null;
        isActive = true;
    }

}
