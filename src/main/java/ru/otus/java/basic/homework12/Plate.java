package ru.otus.java.basic.homework12;

public class Plate {
    private int capacity;
    private int filling;

    public Plate(int capacity) {
        this.capacity = capacity;
        this.filling = capacity;
    }

    public int getFilling() {
        return filling;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addItems(int volume) {
        this.filling += volume;
        if (this.filling > this.capacity) {
            this.filling = this.capacity;
        }
    }

    public boolean removeItem(int volume) {
        this.filling -= volume;
        if (this.filling < 0) {
            this.filling = 0;
            return false;
        }
        return true;
    }
}
