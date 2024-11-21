package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Terrain;

public class AllTerrainVehicle implements Transport {
    private String name;
    private int fuel;
    private int maxFuel;
    private boolean isActive;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Вездеход \"" + name + "\" | Топливо: " + fuel + "/" + maxFuel + " | Труднопроходимый ландшафт: нет");
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return true;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        fuel -= distance;
        if (fuel < 0) {
            isActive = false;
            System.out.println("....Не получилось преодолеть " + terrain.getName() + ".");
            return false;
        }
        System.out.println("...." + terrain.getName() + " преодолена.");
        return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public AllTerrainVehicle(String name, int fuel) {
        this.name = name;
        this.fuel = fuel;
        maxFuel = fuel;
        isActive = true;
    }
}
