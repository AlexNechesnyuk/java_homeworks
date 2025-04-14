package ru.otus.java.basic.homeworks.homework_18;

import java.util.*;

public class PersonDataBase {
    private Map<Long, Person> persons = new HashMap<>();

    public void add(Person person) {
        persons.put(person.getId(), person);
    }

    public Person findById(Long id) {
        return persons.get(id);
    }

    public static boolean isManager(Person person) {
        return person.isManager();
    }

    public boolean isEmployee(Long id) {
        Person person = persons.get(id);
        if (person == null)
            return false;
        return !person.isManager();
    }
}
