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
        System.out.println(pb.containsPhoneNumber(123456));
        System.out.println(pb.containsPhoneNumber(1234567));
    }
}
