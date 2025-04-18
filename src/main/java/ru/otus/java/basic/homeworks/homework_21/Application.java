package ru.otus.java.basic.homeworks.homework_21;

public class Application {

    private static class TimeMeasure {
        long start = System.currentTimeMillis();

        private void info() {
            System.out.println((System.currentTimeMillis() - start) / 1000.0 + "s");
        }

        private void restart() {
            start = System.currentTimeMillis();
        }
    }

    private static class MyTask implements Runnable {
        private final double[] array;
        private final int offset;
        private final int count;

        public MyTask(double[] array, int count, int offset) {
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

    private static final int arraySize = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        TimeMeasure tm = new TimeMeasure();
        double[] array = new double[arraySize];


        MyTask task = new MyTask(array, arraySize, 0);
        task.run();
        tm.info();

        tm.restart();
        Thread[] th = new Thread[4];
        for (int i = 0; i < 4; i++) {
            MyTask t = new MyTask(array, arraySize / 4, arraySize / 4 * i);
            th[i] = new Thread(t);
            th[i].start();
        }
        for (int i = 0; i < 4; i++) {
            th[i].join();
        }
        tm.info();
    }
}
