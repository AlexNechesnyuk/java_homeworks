package ru.otus.java.basic.homeworks;

public class Box {
    private int length, width, height;
    private String color;
    private boolean isOpened;
    private String thing;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        isOpened = false;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        this.isOpened = true;
    }

    public void close() {
        this.isOpened = false;
    }

    public void traceInfo() {
        System.out.print("Box, " + length + 'x' + width + 'x' + height + ", " + color);
        if (thing != null) {
            System.out.println(", contains " + thing);
        } else {
            System.out.println(", is empty");
        }
    }

    public void putThing(String thing) {
        if (!isOpened) {
            System.out.println("Error: Box is closed");
            return;
        }
        if (this.thing != null) {
            System.out.println("Box already contains " + this.thing);
            return;
        }
        this.thing = thing;
        System.out.println("Put " + this.thing + " to a box");
    }

    public void dropThing() {
        if (!isOpened) {
            System.out.println("Error: Box is closed");
            return;
        }
        if (this.thing == null) {
            System.out.println("Box is empty");
            return;
        }
        System.out.println("threw the " + this.thing + " out of the box");
        this.thing = null;
    }
}
