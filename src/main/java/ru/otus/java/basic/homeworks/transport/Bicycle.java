package ru.otus.java.basic.homeworks.transport;

import ru.otus.java.basic.homeworks.Human;
import ru.otus.java.basic.homeworks.Terrain;

public class Bicycle implements Transport {
    private final int enduranceConsumption = 1;

    public boolean move(int distance, Terrain terrain, Human human) {
        if (terrain == Terrain.SWAM) {
            System.out.println("Велосипед не ездит по болоту");
            return false;
        }
        int humanEndurance = human.getEndurance();
        if (distance * enduranceConsumption > humanEndurance) {
            System.out.println("Недостаточно сил у велосипедиста");
            return false;
        }
        System.out.println("Велосипедист проехал " + distance);
        human.setEndurance(humanEndurance - distance * enduranceConsumption);
        return true;
    }

    @Override
    public String toString() {
        return ("Bicycle");
    }

}
