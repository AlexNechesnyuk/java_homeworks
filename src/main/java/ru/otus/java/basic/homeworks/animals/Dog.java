package ru.otus.java.basic.homeworks.animals;

public class Dog extends Animals {
    final int ENDURANCE_COST_SWIM = 2;

    public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
        enduranceCostSwim = ENDURANCE_COST_SWIM;
    }
}
