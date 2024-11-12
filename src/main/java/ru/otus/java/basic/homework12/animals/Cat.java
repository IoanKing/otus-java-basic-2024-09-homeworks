package ru.otus.java.basic.homework12.animals;

import ru.otus.java.basic.homework12.Plate;

public class Cat extends Animal {
    public Cat(String name, int appetite) {
        super(name, appetite);
    }

    public boolean eating(Object obj) {
        if (obj instanceof Plate) {
            int plateFilling = ((Plate) obj).getFilling();
            int catAppetite = getAppetite();
            if (plateFilling >= catAppetite && isHungry) {
                ((Plate) obj).removeItem(catAppetite);
                feed();
                return true;
            }
        }
        return false;
    };
}
