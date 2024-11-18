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
     * @param amount количество убавляемой еды.
     * @return получилось ли убрать из тарелки volume еды? (true|false)
     */
    public boolean removeItem(int amount) {
        if (this.filling < amount) {
            return false;
        }
        this.filling -= amount;
        return true;
    }
}
