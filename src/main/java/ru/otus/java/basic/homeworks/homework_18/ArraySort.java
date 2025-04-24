package ru.otus.java.basic.homeworks.homework_18;

public class ArraySort {
    public static void quickSort(int[] l) {
        quickSort(l, 0, l.length);
    }

    private static void quickSort(int[] l, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1)
            return;
        int wall = startIndex;
        int pivot = endIndex - 1;
        for (int i = startIndex; i < endIndex - 1; i++) {
            if (l[i] < l[pivot]) {
                swap(l, i, wall);
                wall++;
            }
        }
        swap(l, pivot, wall);
        quickSort(l, startIndex, wall);
        quickSort(l, wall + 1, endIndex);
    }

    public static void bubbleSort(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < i; j++) {
                if (l[i] < l[j]) {
                    swap(l, i, j);
                }
            }
        }
    }

    private static void swap(int[] l, int a, int b) {
        // прав ли я что не проверяю границы массива для private функции? Проверка ощутимо утяжеляет процесс
        int temp = l[a];
        l[a] = l[b];
        l[b] = temp;
    }

}
