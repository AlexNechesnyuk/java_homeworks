package ru.otus.java.basic.homeworks;

public class Application {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat cat1 = new Cat("Cat1", 25);
        Cat cat2 = new Cat("Cat2", 35);
        Cat cat3 = new Cat("Cat3", 45);
        Cat cat4 = new Cat("Cat4", 15);

        Cat[] cats = {cat1, cat2, cat3, cat4};

        for (Cat c : cats)
            c.eat(plate);

        for (Cat c : cats)
            c.traceInfo();

        plate.addFood(50);
        plate.addFood(50);

        for (Cat c : cats)
            c.eat(plate);

        for (Cat c : cats)
            c.traceInfo();

    }
}
