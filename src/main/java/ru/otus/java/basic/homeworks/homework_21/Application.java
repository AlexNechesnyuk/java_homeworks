package ru.otus.java.basic.homeworks.homework_21;

public class Application {
    private static final int arraySize = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        TimeMeasure tm = new TimeMeasure();
        double[] array = new double[arraySize];


        TestTask task = new TestTask(array, arraySize, 0);
        task.run();
        tm.info();

        tm.restart();
        Thread[] th = new Thread[4];
        for (int i = 0; i < 4; i++) {
            TestTask t = new TestTask(array, arraySize / 4, arraySize / 4 * i);
            th[i] = new Thread(t);
            th[i].start();
        }
        for (int i = 0; i < 4; i++) {
            th[i].join();
        }
        tm.info();
    }
}
