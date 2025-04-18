package ru.otus.java.basic.homeworks.homework_21;

public class TimeMeasure {
    long start = System.currentTimeMillis();

    public void info() {
        System.out.println((System.currentTimeMillis() - start) / 1000.0 + "s");
    }

    public void restart() {
        start = System.currentTimeMillis();
    }
}
