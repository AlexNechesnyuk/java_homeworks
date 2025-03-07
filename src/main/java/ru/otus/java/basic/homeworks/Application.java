package ru.otus.java.basic.homeworks;

import ru.otus.java.basic.homeworks.animals.*;

public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog("Полиграф", 4, 2, 15);
        Horse horse = new Horse("Росинант", 10, 2, 15);
        Cat cat1 = new Cat("Бегемот", 3, 15);
        Cat cat2 = new Cat("Кот Чеширский", 3, 0, 15);

        Animals animals[] = {dog, horse, cat1, cat2};

        for (Animals a : animals) {
            for (int i = 0; i < 10; i++) {
                int rc = a.swim(4);
                a.info();
                rc = a.run(3);
                a.info();
                if (rc < 0)
                    break;
            }
            System.out.println("---------------");
        }
    }
}
