package ru.otus.java.basic.homeworks.homework_21;

public class TestTask implements Runnable {
    private final double[] array;
    private final int offset;
    private final int count;

    public TestTask(double[] array, int count, int offset) {
        this.array = array;
        this.count = count;
        this.offset = offset;
    }

    @Override
    public void run() {
        for (int i = offset; i < offset + count; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}
