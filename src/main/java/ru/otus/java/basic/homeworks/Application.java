package ru.otus.java.basic.homeworks;

import ru.otus.java.basic.homeworks.transport.AllTerrainVehicle;
import ru.otus.java.basic.homeworks.transport.Bicycle;
import ru.otus.java.basic.homeworks.transport.Horn;
import ru.otus.java.basic.homeworks.transport.Vehicle;

public class Application {
    public static void main(String[] args) {
        Horn horn = new Horn();
        Bicycle bicycle = new Bicycle();
        AllTerrainVehicle atv = new AllTerrainVehicle();
        Vehicle vehicle = new Vehicle();
        Human John = new Human("John Coltrane", 2000);
        John.useTransport(bicycle);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.freeTransport();
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.useTransport(bicycle);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.freeTransport();
        John.useTransport(atv);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.freeTransport();
        John.useTransport(vehicle);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
        John.move(500, Terrain.SWAM);
        John.move(500, Terrain.FOREST);
        John.move(500, Terrain.PLAIN);
    }
}
