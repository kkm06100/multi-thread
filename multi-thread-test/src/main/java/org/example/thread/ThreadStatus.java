package org.example.thread;

public class ThreadStatus {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrupted -> wake!!");
            }
        });
        System.out.println(thread1.getState()); // NEW

        thread1.start();
        System.out.println(thread1.getState()); // RUNNABLE

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread1.getState()); // TIMED_WAITING (in wait_set)

        thread1.interrupt(); // wake sleep

        System.out.println(thread1.getState()); // TERMINATED
    }
}
