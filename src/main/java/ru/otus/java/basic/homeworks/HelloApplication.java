package ru.otus.java.basic.homeworks;

import java.util.Scanner;

public class HelloApplication {
    //                Каждый метод последовательно вызовите из метода main();
    //    (*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод, соответствующий указанному номеру со случайным значением аргументов;
    public static void main(String[] args) {
        greetings();
        checkSign(1, 2, -3);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10, 20, true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер метода (1..5)");
        int method = scanner.nextInt();
        if (method == 1) {
            greetings();
        } else if (method == 2) {
            int a = (int) (Math.random() * 100), b = (int) (Math.random() * 100), c = (int) (Math.random() * 100);
            checkSign(a, b, c);
        } else if (method == 3) {
            selectColor();
        } else if (method == 4) {
            compareNumbers();
        } else if (method == 5) {
            int a = (int) (Math.random() * 100), b = (int) (Math.random() * 100);
            boolean c = Math.random() > 0.5;
            addOrSubtractAndPrint(a, b, c);
        } else {
            System.out.println("Ошибка ввода");
        }
    }

    //                (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    //                (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c. Метод должен посчитать их сумму,
//                и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //                (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
//                Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”,
//                если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;
    public static void selectColor() {
        int data = 10;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //                (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
//                Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers() {
        int a = 10, b = 20;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //                (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true,
//                то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            initValue += delta;
        } else {
            initValue -= delta;
        }
        System.out.println(initValue);
    }
}
