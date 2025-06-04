package ru.otus.java.basic.homeworks.homework_28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AltDimensionTest {

    @Test
    void dimensionTailGetPass() {
        int[] data = new int[]{1, 2, 2, 2, 1, 2, 1, 2, 2};
        Assertions.assertArrayEquals(new int[]{2, 2}, AltDimension.dimensionTailGet(data));
    }

    @Test
    void dimensionTailGetException() {
        int[] data = new int[]{10, 2, 2, 2, 10, 2, 10, 2, 2};
        Assertions.assertThrows(RuntimeException.class, () -> {
            AltDimension.dimensionTailGet(data);
        });
    }

    @Test
    void dimensionCheckTrue() {
        int[] data = new int[]{1, 2, 2, 2, 1, 2, 1, 2, 2};
        Assertions.assertTrue(AltDimension.dimensionCheck(data));
    }

    @Test
    void dimensionCheckFalse() {
        int[] data = new int[]{1, 2, 2, 21, 1, 2, 1, 2, 2};
        Assertions.assertFalse(AltDimension.dimensionCheck(data));
    }
}