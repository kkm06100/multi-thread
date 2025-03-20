package org.example.thread;

import org.example.thread.util.TimeChecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUsage {
    private static final int THREAD_POOL_SIZE = 7;

    public static void main(String[] args) {
        singletonThreadExecutor();
        threadPoolExecutor();
        // threadCacheExecutor();
    }

    /**
     * <h2>Create Singleton Thead Executor</h2>
     * All task run in singleton thread
     */
    private static void singletonThreadExecutor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }

    /**
     * <h2>Create Thread Pool Executor</h2>
     * Task gets thread
     */
    private static void threadPoolExecutor() {
        // todo : What is threadFactory? -> go study
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < 50; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }

    /**
     * <h2>Create Cached Executor</h2>
     * Task gets <b>unique</b> thread
     */
    private static void threadCacheExecutor(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++){
            TimeChecker.start(i + 1);
        }
        executor.shutdown();
    }
}
