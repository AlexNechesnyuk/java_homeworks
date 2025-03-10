package ru.otus.java.basic.homeworks;

public class Plate {
    private final int volume;
    private int fullness;

    public Plate(int volume) {
        this.volume = volume;
        fullness = volume;
    }

    public void addFood(int addition) {
        if (addition < 0 || fullness + addition > volume) {
            System.out.println("Тарелка не вместит столько пищи");
            return;
        }
        fullness += addition;
        System.out.println("Тарелка пополнена до " + fullness);
    }

    public boolean consumeFood(int foodPortion) {
        if (foodPortion > fullness) {
            return false;
        }
        fullness -= foodPortion;
        return true;
    }

}
