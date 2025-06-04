package ru.otus.java.basic.homeworks.homework_28;

import java.util.Arrays;

public class AltDimension {

    public static int[] dimensionTailGet(int[] data) throws RuntimeException {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 1) {
                return Arrays.copyOfRange(data, i + 1, data.length);
            }
        }
        throw new RuntimeException("Значение 1 не найдено");
    }

    public static boolean dimensionCheck(int[] data) throws RuntimeException {
        boolean foundOne = false, foundTwo = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                foundOne = true;
            } else if (data[i] == 2) {
                foundTwo = true;
            } else {
                return false;
            }
        }
        return (foundOne & foundTwo);
    }
}
