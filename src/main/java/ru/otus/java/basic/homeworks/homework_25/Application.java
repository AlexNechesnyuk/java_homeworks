package ru.otus.java.basic.homeworks.homework_25;

public class Application {
    public static void main(String[] args) {

        Box<Fruit> boxFruit = new Box<>();
        Box<Orange> boxOrange = new Box<>();
        Box<Apple> boxApple = new Box<>();

        Apple apple = new Apple(200);
        Orange orange = new Orange(100);
        Fruit pear = new Fruit(150);

        boxFruit.addFruit(apple);
        boxFruit.addFruit(orange);
        boxFruit.addFruit(pear);

        boxOrange.addFruit(orange);

        boxApple.addFruit(apple);
        boxApple.addFruit(new Apple(250));

        System.out.println("boxFruit weight is " + boxFruit.weight());
        System.out.println("boxApple weight is " + boxApple.weight());
        System.out.println("boxOrange weight is " + boxOrange.weight());

        System.out.println("boxApple.compare(boxFruit) is " + boxApple.compare(boxFruit));
        System.out.println("boxOrange.compare(boxFruit) is " + boxApple.compare(boxOrange));

        boxApple.moveToAnotherBox(boxFruit);

        System.out.println("boxFruit weight is " + boxFruit.weight());
        System.out.println("boxApple weight is " + boxApple.weight());
        System.out.println("boxOrange weight is " + boxOrange.weight());

    }
}
