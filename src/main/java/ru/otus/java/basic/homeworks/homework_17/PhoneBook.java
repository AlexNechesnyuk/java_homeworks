package ru.otus.java.basic.homeworks.homework_17;

import java.util.*;

public class PhoneBook {
    protected Map<String, Set<Integer>> phoneBook = new HashMap<>();

    public Set<Integer> find(String name) {
        return phoneBook.get(name);
    }

    public void add(String name, int phoneNumber) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
//        Set<Integer> phones = find(name);
//        if (phones == null) {
//            phoneBook.put(name, new HashSet<>());
//        }
//        find(name).add(phoneNumber);
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public String containsPhoneNumber(int phoneNumber) {
        for (Map.Entry<String, Set<Integer>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
