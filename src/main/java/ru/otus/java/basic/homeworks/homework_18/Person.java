package ru.otus.java.basic.homeworks.homework_18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private Position position;
    private Long id;
    private static Long counter = 0L;
    private final Set<Position> isManager = new HashSet<>(Arrays.asList(Position.MANAGER, Position.DIRECTOR, Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER));


    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        this.id = counter++;
    }

    public Long getId() {
        return id;
    }

    public boolean isManager() {
        return isManager.contains(position);
    }
}
