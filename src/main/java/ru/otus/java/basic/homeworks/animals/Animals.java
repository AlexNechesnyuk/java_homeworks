package ru.otus.java.basic.homeworks.animals;

public abstract class Animals {
    final int ENDURANCE_COST_RUN = 1;
    final int RETURN_ON_ERROR = -1;
    String name;
    int runSpeed;
    int swimSpeed;
    int endurance;
    int enduranceCostSwim;
    int enduranceCostRun;

    Animals(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        this.enduranceCostRun = ENDURANCE_COST_RUN;
    }

    public int run(int distance) {
        int reqTime = distance / runSpeed;
        int reqEndurance = distance * enduranceCostRun;
        if (reqEndurance > endurance) {
            System.out.println("Во время бега, у " + name + " появилось состояние усталости");
            endurance = 0;
            return RETURN_ON_ERROR;
        }
        endurance -= reqEndurance;
        System.out.println(name + " пробежал " + distance + " км за " + reqTime + " часов");
        return reqTime;
    }

    public int swim(int distance) {
        if (enduranceCostSwim == 0) {
            System.out.println(name + " не умеет плавать!");
            return RETURN_ON_ERROR;
        }
        int reqTime = distance / swimSpeed;
        int reqEndurance = distance * enduranceCostSwim;
        if (reqEndurance > endurance) {
            System.out.println("Во время плавания, у " + name + " появилось состояние усталости");
            endurance = 0;
            return RETURN_ON_ERROR;
        }
        endurance -= reqEndurance;
        System.out.println(name + " проплыл " + distance + " км за " + reqTime + " часов");
        return reqTime;
    }

    public void info() {
        System.out.println(name + ": скорость бега: " + runSpeed + "; скорость плавания: " + swimSpeed +
                "; запас выносливости: " + endurance + "; затраты выносливоси на 1 км бега: " + enduranceCostRun +
                "; затраты выносливоси на 1 км плавания: " + enduranceCostSwim);
    }

}
