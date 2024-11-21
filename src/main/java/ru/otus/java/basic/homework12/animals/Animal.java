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

    public void setHungry() {
        isHungry = true;
    }

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isHungry = true;
    }

    public void getInfo() {
        System.out.println(name + " с аппетитом " + appetite + ".  Голодный: " + isHungry);
    }

    @Override
    public String toString() {
        return name + " с аппетитом " + appetite + ".  Голодный: " + isHungry;
    };
}
