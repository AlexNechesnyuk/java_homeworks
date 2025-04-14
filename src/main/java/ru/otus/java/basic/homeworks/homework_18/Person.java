package ru.otus.java.basic.homeworks.homework_18;

public class Person {
    private String name;
    private Position position;
    private Long id;
    private static Long counter = 0L;
    private boolean isManager;

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        this.id = counter++;
        switch (position) {
            case MANAGER:
            case DIRECTOR:
            case BRANCH_DIRECTOR:
            case SENIOR_MANAGER:
                isManager = true;
                break;
            default:
                isManager = false;
        }
    }

    public Long getId() {
        return id;
    }

    public boolean isManager() {
        return isManager;
    }
}
