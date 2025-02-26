package ru.otus.java.basic.homeworks;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {

    }


    //Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
    // метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
    public static int sumOfPositiveElements(int[][] arg) {
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                if (arg[i][j] > 0) {
                    sum += arg[i][j];
                }
            }
        }
        return sum;
    }

    //Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов *
    // со сторонами соответствующей длины;
    public static void printSquare(int squareSide) {
        for (int i = 0; i < squareSide; i++) {
            for (int j = 0; j < squareSide; j++) {
                if (i == 0 || j == 0 || i == squareSide - 1 || j == squareSide - 1) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    //Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
    // и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
    // Реализовано для квадратной матрицы!
    public static void fillSquareDiagonals(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                if (i == j || i == arg[i].length - j - 1) {
                    arg[i][j] = 0;
                }
            }
        }
    }

    //Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
    public static int findMax(int[][] arg) {
        int maxValue = arg[0][0];
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                if (maxValue < arg[i][j]) {
                    maxValue = arg[i][j];
                }
            }
        }
        return maxValue;
    }

    //Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
    // если второй строки не существует, то в качестве результата необходимо вернуть -1
    // Вторая, считая с НУЛЯ
    public static int secondLineSum(int[][] arg) {
        if (arg.length < 3 || arg[2].length == 0)
            return -1;
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            sum += arg[2][i];
        }
        return sum;
    }


}







