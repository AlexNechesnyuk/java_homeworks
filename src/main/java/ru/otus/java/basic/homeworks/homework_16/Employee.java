package ru.otus.java.basic.homeworks.homework_16;

import java.util.List;

public class Employee {
    private final int age;
    private final String name;

    public Employee(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
