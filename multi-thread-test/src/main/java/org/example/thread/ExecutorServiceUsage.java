package org.example.thread;

import org.example.thread.util.TimeChecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUsage {
    private static final int THREAD_POOL_SIZE = 7;

    public static void main(String[] args) {
//        singletonThreadExecutor();
        threadPoolExecutor();
//         threadCacheExecutor();
    }

    private static void singletonThreadExecutor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }

    private static void threadPoolExecutor() {
        // todo : What is threadFactory? -> go study
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < 15; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }

    private static void threadCacheExecutor(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }
}
