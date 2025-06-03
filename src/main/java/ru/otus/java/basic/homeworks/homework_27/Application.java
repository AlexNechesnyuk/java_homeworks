package ru.otus.java.basic.homeworks.homework_27;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    static int curStep = 0;
    static final Object mon = new Object();
    static final int iter = 5;

    public static void main(String[] args) {
        int step = 0;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new PrintCharTask('A', 0));
        executor.submit(new PrintCharTask('B', 1));
        executor.submit(new PrintCharTask('C', 2));
        executor.shutdown();
    }

    static class PrintCharTask implements Runnable {
        private final char character;
        private final int step;

        PrintCharTask(char character, int step) {
            this.character = character;
            this.step = step;
        }

        @Override
        public void run() {
            synchronized (mon) {
                for (int i = 0; i < iter; i++) {
                    while (curStep != step) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(character);
                    curStep++;
                    if (curStep == 3)
                        curStep = 0;
                    mon.notifyAll();
                }
            }
        }
    }
}

