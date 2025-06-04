package ru.otus.java.basic.homeworks.homework_25;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> items = new ArrayList<>();

    public void addFruit(T fruit) {
        items.add(fruit);
    }

    public int weight() {
        int w = 0;
        for(T fruit: items) {
            w += fruit.getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> other) {
        return this.weight() == other.weight();
    }

    public void moveToAnotherBox(Box<? super T> other) {
        if (this == other)
            return;
        for (T fruit: items){
            other.addFruit(fruit);
        }
        items.clear();
    }


}
