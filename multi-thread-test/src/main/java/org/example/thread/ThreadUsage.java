package org.example.thread;

public class ThreadUsage {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.printf("Hello? %dms\n", System.currentTimeMillis() - start);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Im not ok %dms\n", System.currentTimeMillis() - start);
        });

        Thread thread2 = new Thread(() -> {
            long start = System.currentTimeMillis();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("Are you ok? %dms\n", System.currentTimeMillis() - start);
        });

        thread1.start();
        thread2.start();
    }
}