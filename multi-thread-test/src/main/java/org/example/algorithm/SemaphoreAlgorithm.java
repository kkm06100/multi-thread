package org.example.algorithm;

import java.util.concurrent.Semaphore;

public class SemaphoreAlgorithm {
    private static final Semaphore semaphore = new Semaphore(3); // max Thread

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(new Wait(i)).start();
        }
    }

    static class Wait implements Runnable {

        private final int workerId;

        Wait(int workerId) {
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Worker " + workerId + " is working");
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("Worker " + workerId + " is finished");
                semaphore.release();
            }
        }
    }
}
