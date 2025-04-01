package ru.otus.java.basic.homeworks.transport;

import ru.otus.java.basic.homeworks.Human;
import ru.otus.java.basic.homeworks.Terrain;

public class AllTerrainVehicle implements Transport {
    private final int fuelConsumption = 5;
    private int fuel = 10000;

    public boolean move(int distance, Terrain terrain, Human human) {
        if (distance * fuelConsumption > fuel) {
            System.out.println("Недостаточно топлива");
            return false;
        }
        System.out.println("Вездеход проехал " + distance);
        fuel -= distance * fuelConsumption;
        return true;
    }

    @Override
    public String toString() {
        return ("All terrain vehicle");
    }


}
