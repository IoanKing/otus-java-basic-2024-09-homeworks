package ru.otus.java.basic.homework11.animals;

public abstract class Animal {
    protected String name;
    protected int groundSpeed;
    protected int waterSpeed;
    protected int endurance;
    protected int maxEndurance;
    protected String type;
    protected boolean isTired;

    public Animal(String name, int groundSpeed, int waterSpeed, int endurance, String type) {
        this.name = name;
        this.groundSpeed = groundSpeed;
        this.waterSpeed = waterSpeed;
        this.endurance = endurance;
        this.maxEndurance = endurance;
        this.type = type;
        this.isTired = false;
    }

    public String getName() {
        return name;
    }

    public int getGroundSpeed() {
        return groundSpeed;
    }

    public int getWaterSpeed() {
        return waterSpeed;
    }

    public int getEndurance() {
        return endurance;
    }

    public boolean isTired() {
        return isTired;
    }

    public String getType() {
        return type;
    }

    public int run(int distance) {
        if (groundSpeed <= 0) {
            return -1;
        }
        int time = distance * groundSpeed;
        if (endurance < time) {
            isTired = true;
            endurance = 0;
            return -1;
        }
        endurance -= time;
        return time;
    }

    public int swim(int distance) {
        if (waterSpeed <= 0) {
            return -1;
        }
        int time = distance * waterSpeed;
        if (endurance < time) {
            isTired = true;
            endurance = 0;
            return -1;
        }
        endurance -= time;
        return time;
    }

    @Override
    public String toString() {
        return type + " " + name + " " + groundSpeed + " " + waterSpeed + " " + endurance + " " + maxEndurance + " " + type + " " + isTired;
    };

    public void info() {
        String swimEffort = "| плавает с усилием " + waterSpeed;
        String runEffort = "| бегает с усилием " + groundSpeed;
        String status = "";

        if (waterSpeed < 0) {
            swimEffort = "| не плавает";
        }
        if (groundSpeed < 0) {
            runEffort = "| не бегает";
        }
        if (isTired) {
            status = "(Усталость)";
        }

        System.out.println(type + " \"" + name + "\" " + runEffort + " " + swimEffort + " | Выносливость: " + endurance + " | " + status);
    }

    public void resetStatus() {
        endurance = maxEndurance;
        isTired = false;
    }
}
