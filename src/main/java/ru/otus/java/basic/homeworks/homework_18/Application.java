

package ru.otus.java.basic.homeworks.homework_18;

import java.util.*;

public class Application {


    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            al.add(i);
        }
        SearchTree<Integer> st = new SearchTree<>(al);
        System.out.println(st.find(10));

        List<Integer> out = st.getSortedList();
        System.out.println(out);


        PersonDataBase db = new PersonDataBase();
        db.add(new Person("qqq", Position.SENIOR_MANAGER));
        db.add(new Person("www", Position.MANAGER));
        db.add(new Person("eee", Position.ENGINEER));

        System.out.println(db.findById(1L));
        System.out.println(db.findById(7L));
        System.out.println(db.isEmployee(2L));
        System.out.println(db.isEmployee(1L));
        Person pfoundPerson = db.findById(1L);
        System.out.println(PersonDataBase.isManager(pfoundPerson));


        for (int iter = 0; iter < 3; iter++) {
            Random random = new Random();
            int[][] l = new int[4][100000];
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 100000; i++) {
                    int v = random.nextInt(1000);
                    l[j][i] = v;
                }
            }
            long start, end;
            start = System.currentTimeMillis();
            ArraySort.bubbleSort(l[0]);
            end = System.currentTimeMillis();
            System.out.println("bubbleSort " + (end - start));

            start = System.currentTimeMillis();
            Arrays.sort(l[1]);
            end = System.currentTimeMillis();
            System.out.println("Arrays.sort " + (end - start));

            start = System.currentTimeMillis();
            ArraySort.quickSort(l[2]);
            end = System.currentTimeMillis();
            System.out.println("quickSort " + (end - start));

            start = System.currentTimeMillis();
            Arrays.parallelSort(l[3]);
            end = System.currentTimeMillis();
            System.out.println("Arrays.parallelSort " + (end - start));

            for (int i = 0; i < l.length; i++) {
                for (int j = 0; j < l[i].length - 1; j++) {
                    if (l[i][j] > l[i][j + 1])
                        throw new RuntimeException("Ошибка сортировки в методе " + i);
                }
            }
            System.out.println("======================");
        }
    }
}
