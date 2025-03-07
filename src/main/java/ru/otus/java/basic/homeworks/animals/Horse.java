package ru.otus.java.basic.homeworks.animals;

public class Horse extends Animals {
    final int ENDURANCE_COST_SWIM = 4;

    public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
        enduranceCostSwim = ENDURANCE_COST_SWIM;
    }
}

