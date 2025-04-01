package ru.otus.java.basic.homeworks.transport;

import ru.otus.java.basic.homeworks.Human;
import ru.otus.java.basic.homeworks.Terrain;

public class Horn implements Transport {
    private final int hornEnduranceConsumption = 1;
    private int resource = 1000;

    public boolean move(int distance, Terrain terrain, Human human) {
        if (terrain == Terrain.SWAM) {
            System.out.println("Лошадь не ходит по болоту");
            return false;
        }

        if (distance * hornEnduranceConsumption > resource) {
            System.out.println("Недостаточно сил у лошади");
            return false;
        }
        System.out.println("Лошадь проскакала " + distance);
        resource -= distance * hornEnduranceConsumption;
        return true;
    }

    @Override
    public String toString() {
        return ("Horn");
    }


}
