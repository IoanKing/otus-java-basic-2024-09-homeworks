package ru.otus.java.basic.homework12.animals;

public abstract class Animal {
    protected String name;
    protected int appetite;
    protected boolean isHungry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void feed() {
        isHungry = false;
    }

    public void setHungry() {
        isHungry = true;
    }

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isHungry = true;
    }

    @Override
    public String toString() {
        return "Кот " + name + " с аппетитом " + appetite + ".  Голодный: " + isHungry;
    };
}
