package ru.otus.java.basic.homeworks;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        if(appetite <= 0) {
            throw new IllegalArgumentException("Некорректное значение аппетита: " + appetite);
        }
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate plate) {
        if (!isFull)
            isFull = plate.consumeFood(appetite);
    }

    public void traceInfo() {
        System.out.println(name + (isFull ? " сыт" : " остался голодным"));
    }
}
