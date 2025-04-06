package ru.otus.java.basic.homeworks.homework_17;

import java.util.*;

public class PhoneBook {
    protected Map<String, Set<Integer>> phoneBook = new HashMap<>();

    public Set<Integer> find(String name) {
        return phoneBook.get(name);
    }

    public void add(String name, int phoneNumber) {
        Set<Integer> phones = find(name);
        if (phones == null) {
            phoneBook.put(name, new HashSet<>());
        }
        find(name).add(phoneNumber);
    }

    public boolean containsPhoneNumber(int phoneNumber) {
        for (Map.Entry<String, Set<Integer>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                System.out.println("Телефон " + phoneNumber + " принадлежит " + entry.getKey());
                return true;
            }
        }
        System.out.println("Телефон " + phoneNumber + " никому не принадлежит");
        return false;
    }

}
