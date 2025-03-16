package ru.otus.java.basic.homeworks.transport;

import ru.otus.java.basic.homeworks.Human;
import ru.otus.java.basic.homeworks.Terrain;

public class Vehicle implements Transport {
    private final int consumption = 2;
    private int fuel = 10000;

    public boolean move(int distance, Terrain terrain, Human human) {
        if (terrain == Terrain.FOREST || terrain == Terrain.SWAM) {
            System.out.println("Авто не ездит по " + (terrain == Terrain.FOREST ? "лесу" : "болоту"));
            return false;
        }
        if (distance * consumption > fuel) {
            System.out.println("Недостаточно топлива");
            return false;
        }
        System.out.println("Автомобиль проехал " + distance);
        fuel -= distance * consumption;
        return true;
    }

    @Override
    public String toString() {
        return ("Vehicle");
    }


}
