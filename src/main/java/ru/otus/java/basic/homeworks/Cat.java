package ru.otus.java.basic.homeworks;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate plate) {
        if (!isFull)
            isFull = plate.consumeFood(appetite);
    }

    public void traceInfo() {
        if (isFull)
            System.out.println(name + " сыт");
        else
            System.out.println(name + " остался голодным");
    }
}
