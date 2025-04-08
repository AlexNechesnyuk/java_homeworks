package ru.otus.java.basic.homeworks.homework_17;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("qwerty", 123456);
        pb.add("qwerty", 123456);
        pb.add("qwerty", 654321);
        System.out.println(pb.find("qwerty"));
        System.out.println(pb.find("ytrewq"));
        int[] testPhones = {123456, 1234567};
        for(int number : testPhones) {
            String name = pb.containsPhoneNumber(number);
            if (name == null) {
                System.out.println("Номер " + number + " никому не принадлежит");
            }
            else {
                System.out.println("Номер " + number + " принадлежит " + name);
            }
        }
    }
}
