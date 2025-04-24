package ru.otus.java.basic.homeworks.homework_19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {
    static private final String rootPath = "../texts1/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File directory = new File(rootPath);
        if (!directory.isDirectory()) {
            System.out.println("Некорректная директория " + rootPath);
            return;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Ошибка при обращении к директории " + rootPath);
            return;
        }
        for (File f : files) {
            if (f.isFile())
                System.out.println(f.getName());
        }
        System.out.println("Выберете один из имеющихся или новый файл");
        String fileName = scanner.nextLine();
        try (InputStreamReader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(rootPath + fileName)))) {
            int total = 0;
            char[] buffer = new char[100];
            while (true) {
                int n = in.read(buffer, total, buffer.length);
                if (n == -1)
                    break;
                System.out.print(new String(buffer, 0, n));
            }
        } catch (IOException e) {
            System.out.println("Создаем новый файл " + rootPath + fileName);
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(rootPath + fileName, true))) {
            String data = scanner.nextLine() + "\r\n";
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (IOException e) {
            System.out.println("Ошибка во время записи");
        }
    }
}
