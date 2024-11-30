package ru.otus.java.basic.homework13.landscape;

import ru.otus.java.basic.homework13.interfaces.Landscape;
import ru.otus.java.basic.homework13.interfaces.Traveler;

public enum Location {
    DENSE_FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото"),
    FILLING_STANTION("Заправочная станция"),
    HAYFIELD("Сенокос"),
    ROADSIDE_HOTEL("Придорожный отель");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

    Location(String name) {
        this.name = name;
    }
}
