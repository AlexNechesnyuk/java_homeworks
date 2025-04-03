package ru.otus.java.basic.homeworks.homework_16;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        List<Integer> l = listSequence(5, 10);
        System.out.println(l);
        System.out.println(listSum(l));
        listIncrease(l, 5);
        System.out.println(l);
        listFill(l, 5);
        System.out.println(l);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Peter", 25));
        employees.add(new Employee("John", 15));
        employees.add(new Employee("Andrew", 35));

        System.out.println(employees);
        System.out.println(employeesNames(employees));
        System.out.println(oldEmployeesNames(employees, 25));
        System.out.println(teamIsOlder(employees, 24));
        System.out.println(theYoungest(employees).getName());
    }

    private static List<Integer> listSequence(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>(Math.max(0, max - min + 1));
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    private static int listSum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            if (i > 5) {
                sum += i;
            }
        }
        return sum;
    }

    private static void listFill(List<Integer> list, int value) {
        list.replaceAll(ignored -> value);
    }

    private static void listIncrease(List<Integer> list, int value) {
        list.replaceAll(integer -> integer + value);
    }

    private static List employeesNames(List<Employee> list) {
        ArrayList<String> out = new ArrayList<>(list.size());
        for (Employee employee : list) {
            out.add(employee.getName());
        }
        return out;
    }

    private static List oldEmployeesNames(List<Employee> list, int age) {
        ArrayList<String> out = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= age)
                out.add(employee.getName());
        }
        return out;
    }

    private static boolean teamIsOlder(List<Employee> list, int age) {
        int sumAge = 0;
        for (Employee employee : list) {
            sumAge += employee.getAge();
        }
        return sumAge > age * list.size();
    }

    private static Employee theYoungest(List<Employee> list) {
        Employee youngest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getAge() < youngest.getAge())
                youngest = list.get(i);
        }
        return youngest;
    }

}
