package ru.otus.java.basic.homeworks.homework_26;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
для простоты полагаем, что в паттерне нет символов новой строки
 */

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        System.out.println("Введите шаблон для поиска");
        String pattern = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                int startPos = 0;
                while (true) {
                    startPos = line.indexOf(pattern, startPos);
                    if (startPos >= 0) {
                        startPos += pattern.length();
                        count++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println("найдено " + count + " совпадений");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
