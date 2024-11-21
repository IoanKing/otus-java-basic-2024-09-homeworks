package ru.otus.java.basic.homework12.animals;

import ru.otus.java.basic.homework12.Plate;

public class Cat extends Animal {
    public Cat(String name, int appetite) {
        super(name, appetite);
    }

    public boolean eating(Plate plate) {
        if (isHungry) {
            if (plate.removeItem(appetite)) {
                isHungry = false;
                return true;
            }
        }
        return false;
    }
}
