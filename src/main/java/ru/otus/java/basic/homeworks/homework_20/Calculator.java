package ru.otus.java.basic.homeworks.homework_20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static String calc(String userInput) {
        Pattern p = Pattern.compile("(-?[0-9]+) *([-*+/]) *(-?[0-9]+)");
        Matcher m = p.matcher(userInput);
        if(m.matches()) {
            int A = Integer.parseInt(m.group(1));
            String operator = m.group(2);
            int B = Integer.parseInt(m.group(3));
            switch(operator) {
                case "+":
                    return Integer.toString(A+B);
                case "-":
                    return Integer.toString(A-B);
                case "*":
                    return Integer.toString(A*B);
                case "/":
                    return Float.toString((float)A/B);
            }
        }
        return "Ошибка в выражении " + userInput;
    }
}
