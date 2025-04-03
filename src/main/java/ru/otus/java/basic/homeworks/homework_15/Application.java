package ru.otus.java.basic.homeworks.homework_15;

import ru.otus.java.basic.homeworks.transport.Horn;

public class Application {
    public static void main(String[] args) {
        String[][] a = {{"10", "20", "30", "40"}, {"10", "20", "30", "40"}, {"10", "20", "30", "40"}, {"10", "20", "30", "40"}};
        System.out.println(testMethod(a));

    }

    private static int testMethod(String[][] arg) {
        if (arg.length != 4) {
            throw new AppArraySizeException("Incorrect array size");
        }
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            String[] element = arg[i];
            if (element.length != 4) {
                throw new AppArraySizeException("Incorrect array size");
            }
            for (int j = 0; j < element.length; j++) {
                String item = element[j];
                try {
                    sum += Integer.parseInt(item);
                } catch (Exception s) {
                    throw new AppArrayDataException("Incorrect value in cell " + i + ' ' + j);
                }
            }
        }
        return sum;
    }
}
