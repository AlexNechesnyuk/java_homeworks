package ru.otus.java.basic.homeworks.transport;

import ru.otus.java.basic.homeworks.Human;
import ru.otus.java.basic.homeworks.Terrain;

public interface Transport {
    boolean move(int distance, Terrain terrain, Human human);
}
