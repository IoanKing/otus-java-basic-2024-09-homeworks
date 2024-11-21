package ru.otus.java.basic.homework13.landscape;

public enum Terrain {
    DENSE_FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");

    private String name;

    public String getName() {
        return name;
    }

    Terrain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
