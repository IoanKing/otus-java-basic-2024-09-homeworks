package ru.otus.java.basic.homework11;

import java.util.Objects;

public class Animal {
    private String name;
    private int groundSpeed;
    private int waterSpeed;
    private int endurance;
    private int maxEndurance;
    private String type;

    public Animal(String name, int groundSpeed, int waterSpeed, int endurance, String type) {
        this.name = name;
        this.groundSpeed = groundSpeed;
        this.waterSpeed = waterSpeed;
        this.endurance = endurance;
        this.maxEndurance = endurance;
        this.type = type;
    }

    public int run(int distance) {
        return movement(distance, true);
    }

    public int swim(int distance) {
        return movement(distance, false);
    }

    public int movement (int distance, boolean isRun) {
        int speed = 0;
        int runDistance = 0;
        int time = 0;

        if (isRun) {
            speed = this.groundSpeed;
        } else {
            speed = this.waterSpeed;
        }

        if (speed > 0) {
            while(runDistance < distance && this.endurance >= 0) {
                time++;
                runDistance++;
                this.endurance -= speed;
                if (this.endurance < 0) {
                    this.endurance = 0;
                    return -1;
                }
            };
        }
        return time;
    }

    public void info() {
        String runningText = "";
        String swimmingText = "";
        String status = "";
        if (this.groundSpeed > 0) {
            runningText = " бегает с усилием " + this.groundSpeed;
        } else {
            runningText = " не бегает";
        }

        if (this.waterSpeed > 0) {
            swimmingText = " и плавает с усилием " + this.waterSpeed + ".";
        } else {
            swimmingText = " и не плавает.";
        }

        if (this.endurance == 0) {
            status = "Животное устало.";
        }

        System.out.println(this.type + " \"" + this.name + "\"" + runningText + swimmingText + " Его выносливость: " + this.endurance + ". " + status);
    }

    public void resetStatus() {
        this.endurance = this.maxEndurance;
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

    public String getType() {
        return type;
    }

    public boolean isCanRun() {
        return this.groundSpeed >= 0;
    }

    public boolean isCanSwim() {
        return this.waterSpeed >= 0;
    }
}
