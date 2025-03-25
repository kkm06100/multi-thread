package org.example.algorithm;

import java.util.concurrent.locks.ReentrantLock;

public class MutexAlgorithm {
    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    static class Worker implements Runnable {

        private final int workerId;

        Worker(int workerId) {
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("worker " + workerId + "is running");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
