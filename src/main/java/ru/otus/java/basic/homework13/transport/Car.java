package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Terrain;

import java.util.Arrays;
import java.util.Objects;

public class Car implements Transport {
    private String name;
    private int fuel;
    private int maxFuel;
    private boolean isActive;
    private Terrain[] closedTerrain;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Машина \"" + name + "\" | Топливо: " + fuel + "/" + maxFuel + " | Труднопроходимый ландшафт: " + Arrays.toString(closedTerrain));
    }

    @Override
    public boolean canMove(Terrain terrain) {
        for (Terrain landscape : closedTerrain) {
            if (landscape == terrain) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        for (Terrain landscape : closedTerrain) {
            if (landscape == terrain) {
                System.out.println("....Не получилось преодолеть " + terrain.getName() + ".");
                return false;
            }
        }
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

    public Car(String name, int fuel) {
        this.name = name;
        this.fuel = fuel;
        maxFuel = fuel;
        isActive = true;
        closedTerrain = new Terrain[] {
                Terrain.DENSE_FOREST,
                Terrain.SWAMP
        };
    }
}
