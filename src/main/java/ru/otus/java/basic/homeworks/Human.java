package ru.otus.java.basic.homeworks;

import ru.otus.java.basic.homeworks.transport.Transport;

public class Human implements Transport {
    private String name;
    private Transport currentTransport = this;
    private int endurance;
    int enduranceConsumption = 2;

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }

    public boolean useTransport(Transport transport) {
        if (currentTransport == this) {
            System.out.println(name + " сменил транспорт на " + transport);
            currentTransport = transport;
            return true;
        }
        System.out.println(name + " не смог сменить транспорт на " + transport);
        System.out.println("Сначала надо освободить " + currentTransport);
        return false;
    }

    public void freeTransport() {
        currentTransport = this;
    }

    public boolean move(int distance, Terrain terrain) {
        return currentTransport.move(distance, terrain, this);
    }

    public boolean move(int distance, Terrain terrian, Human human) {
        if (distance * enduranceConsumption > endurance) {
            System.out.println("Недостаточно сил у " + name);
            return false;
        }
        System.out.println(name + " прошел " + distance);
        endurance -= distance * enduranceConsumption;
        return true;
    }

}
