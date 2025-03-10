package ru.otus.java.basic.homeworks.animals;

public class Cat extends Animals {
    final int ENDURANCE_COST_SWIM = 0;

    public Cat(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
        enduranceCostSwim = ENDURANCE_COST_SWIM;
    }

    public Cat(String name, int runSpeed, int endurance) {
        super(name, runSpeed, 0, endurance);
        enduranceCostSwim = ENDURANCE_COST_SWIM;
    }
}