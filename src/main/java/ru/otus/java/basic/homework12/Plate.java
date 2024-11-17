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

    /**
     * Метод добавляет в тарелку еды. В тарелке не может быть еды больше её вместимости.
     * @param volume количество добавляемой еды.
     */
    public void addItems(int volume) {
        this.filling += volume;
        if (this.filling > this.capacity) {
            this.filling = this.capacity;
        }
    }

    /**
     * Метод удаляет из тарелки еду. В тарелке не может быть меньше нуля еды.
     * @param volume количество убавляемой еды.
     * @return
     */
    public boolean removeItem(int volume) {
        this.filling -= volume;
        if (this.filling < 0) {
            this.filling = 0;
            return false;
        }
        return true;
    }
}
