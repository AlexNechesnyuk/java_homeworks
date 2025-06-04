package ru.otus.java.basic.homeworks.homework_28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParametrizedAltDimensionTest {

    int[] stringToIntDim(String input) {
        try {
            String[] parts = input.split(",");
            int[] result = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                result[i] = Integer.parseInt(parts[i].trim());
            }
            return result;
        } catch (Exception e) {
            return new int[0];
        }
    }

    @CsvSource({
            "'1, 2'",
            "'1, 2, 2, 2, 1, 2, 1, 2, 1'",
            "'1, 2, 1, 2, 1, 2, 1, 2'",
            "'1, 2, 2, 1, 1, 2, 1, 2, 2, 1, 1'"
    })
    @ParameterizedTest
    void dimensionCheckTrue(String str) {
        int[] array = stringToIntDim(str);
        Assertions.assertTrue(AltDimension.dimensionCheck(array));
    }

    @CsvSource({
            "'1, 1'",
            "'1, 2, 2, 2, 1, 2, 1, 2, 1, 3'",
            "'2'",
            "'2,2'"
    })
    @ParameterizedTest
    void dimensionCheckFalse(String str) {
        int[] array = stringToIntDim(str);
        Assertions.assertFalse(AltDimension.dimensionCheck(array));
    }

    @CsvSource({
            "'1, 2, 2, 2, 1, 2, 1, 2, 2, 1', ''",
            "'1, 2, 2, 2, 1, 2, 1, 2, 2', '2, 2'",
            "'1, 2, 2, 2, 2, 2, 2, 2', '2, 2, 2, 2, 2, 2, 2'",
    })
    @ParameterizedTest
    void dimensionTailGetPass(String str, String rezult) {
        int[] array = stringToIntDim(str);
        int[] rez = stringToIntDim(rezult);
        Assertions.assertArrayEquals(rez, AltDimension.dimensionTailGet(array));
    }

    @CsvSource({
            "'3, 2, 2, 2'",
            "''",
            "'2, 2, 2, 2, 2, 2, 2'",
    })
    @ParameterizedTest
    void dimensionTailGetException(String str) {
        int[] array = stringToIntDim(str);
        Assertions.assertThrows(RuntimeException.class, () -> {
            AltDimension.dimensionTailGet(array);
        });
    }

}