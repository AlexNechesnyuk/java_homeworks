package ru.otus.java.basic.homeworks;

import java.util.Arrays;

public class HelloApplication {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 20, 30, 4};
        printString(3, "ABCDEF");
        sumElementsMoreFive(arr);
        arrayFill(10, arr);
        arrayIncrease(5, new int[]{1, 2, 3, 8, 7, 6});
        halfsCheck(new int[]{1, 2, 3, 8, 7, 6});
        arraySum(new int[]{1, 2, 3}, new int[]{2, 2}, new int[]{1, 1, 1, 1, 1});
        equallyPossible(new int[]{1, 1, 1, 1, 1, 5});
        equallyPossible(new int[]{1, 1, 1, 1, 1, 6});
        equallyPossible(new int[]{1, 1, 2, 1, 1, 1, 1, 6});
        orderIsCorrect(new int[]{1, 2, 3, 3, 3, 7, 100, 600}, true);
        orderIsCorrect(new int[]{1, 2, 3, 3, 3, 7, 100, 60}, true);
        orderIsCorrect(new int[]{1, 2, 3, 3, 3, 7, 100, 600}, false);
        orderIsCorrect(new int[]{1, 2, 3, 3, 3, 7, 100, 600});
    }

    //    Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку
//    указанное количество раз
    public static void printString(int times, String str) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    //    Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
//    значение которых больше 5, и печатающий полученную сумму в консоль.
    public static void sumElementsMoreFive(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j > 5) {
                sum += j;
            }
        }
        System.out.println("sum " + sum);
    }

    //    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный
//    массив, метод должен заполнить каждую ячейку массива указанным числом;
    public static void arrayFill(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
//        Arrays.fill(array, value);
    }

    //    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
//    увеличивающий каждый элемент которого на указанное число.
    public static void arrayIncrease(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
    }

    //    Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и печатающий в консоль
//    сумма элементов какой из половин массива больше.
    public static void halfsCheck(int[] array) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum1 += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            sum2 += array[i];
        }
        if (sum1 >= sum2) {
            System.out.println("Первая половина больше или равна");
        } else {
            System.out.println("Вторая половина больше");
        }
    }

    //    Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый
//    массив равный сумме входящих;
//    Пример: { 1, 2, 3 }
//    { 2, 2 }
//    { 1, 1, 1, 1, 1}
//    = { 4, 5, 4, 1, 1 }
    public static void arraySum(int[]... array) {
        int maxLen = 0;
        for (int[] a : array) {
            if (maxLen < a.length) {
                maxLen = a.length;
            }
        }
        int[] out = new int[maxLen];
        for (int[] a : array) {
            for (int i = 0; i < a.length; i++) {
                out[i] += a[i];
            }
        }
        System.out.println(Arrays.toString(out));
    }

    //    Реализуйте метод, проверāĀûий ùто естþ “тоùка” в массиве, в которой сумма левой и правой ùасти
//    равнý. “Тоùка находитсā между ÿлементами”;
//    Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
    public static void equallyPossible(int[] array) {
        int sumTotal = 0;
        for (int j : array) {
            sumTotal += j;
        }
        int halfSum = sumTotal / 2;
        int sumLoc = 0;
        System.out.print("{");
        for (int j : array) {
            sumLoc += j;
            System.out.print(j + " ");
            if (sumLoc == halfSum && sumTotal % 2 == 0) {
                System.out.print("| ");
            }
        }
        System.out.println("}");
    }

    //    Реализуйте метод, проверāĀûий ùто все ÿлементý массива идут в порāдке убýваниā или
//    возрастаниā (по вýбору полþзователā)
    public static void orderIsCorrect(int[] array, boolean increase) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((increase && array[i] > array[i + 1]) || (!increase && array[i] < array[i + 1])) {
                System.out.println("Order is incorrect");
                return;
            }
        }
        System.out.println("Order is correct");
    }

    //    Реализуйте метод, “перевораùиваĀûий” входāûий массив
//    Пример: { 1 2 3 4 } => { 4 3 2 1 }
    public static void orderIsCorrect(int[] array) {
        int[] out = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            out[i] = array[array.length - 1 - i];
        }
        System.out.println(Arrays.toString(out));
    }
}
