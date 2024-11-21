package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Terrain;

import java.util.Arrays;
import java.util.Objects;

public class Bicycle implements Transport {
    private String name;
    private Terrain[] closedTerrain;
    private boolean isActive;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Велосипед \"" + name + "\" | Труднопроходимый ландшафт: " + Arrays.toString(closedTerrain));
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
                System.out.println("...Не получилось преодолеть " + terrain.getName() + ".");
                return false;
            }
        }
        System.out.println("..." + terrain.getName() + " преодолена.");
        return true;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    public Bicycle(String name) {
        this.name = name;
        isActive = true;
        closedTerrain = new Terrain[] {
                Terrain.SWAMP
        };
    }
}
