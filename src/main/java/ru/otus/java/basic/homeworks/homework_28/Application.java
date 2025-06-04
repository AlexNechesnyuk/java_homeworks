package ru.otus.java.basic.homeworks.homework_28;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 2, 2, 1, 2, 1, 2, 2};
        System.out.println(Arrays.toString(AltDimension.dimensionTailGet(data)));
        System.out.println(AltDimension.dimensionCheck(data));
    }

}