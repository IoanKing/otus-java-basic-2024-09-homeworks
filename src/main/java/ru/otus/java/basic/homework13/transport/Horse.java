package ru.otus.java.basic.homework13.transport;

import ru.otus.java.basic.homework13.interfaces.Transport;
import ru.otus.java.basic.homework13.landscape.Terrain;

import java.util.Arrays;
import java.util.Objects;

public class Horse implements Transport {
    private String name;
    private int endurance;
    private int maxEndurance;
    private boolean isActive;
    private Terrain[] closedTerrain;

    public void rest() {
        endurance = maxEndurance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getInfo() {
        System.out.println("Лошадь \"" + name + "\" | Выносливость: " + endurance + "/" + maxEndurance + " | Труднопроходимый ландшафт: " + Arrays.toString(closedTerrain));
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
        endurance -= distance;
        if (endurance < 0) {
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

    public Horse(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
        maxEndurance = endurance;
        isActive = true;
        closedTerrain = new Terrain[] {
                Terrain.SWAMP
        };
    }
}
