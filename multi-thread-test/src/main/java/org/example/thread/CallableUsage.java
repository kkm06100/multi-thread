package org.example.thread;

import org.example.thread.util.TimeChecker;

import java.util.concurrent.*;

public class CallableUsage {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            TimeChecker.start(1);
            return "Hello from Callable!";
        };

        // callable --[submit]--> executorService
        Future<String> future = executor.submit(callableTask);

        try {
            System.out.println("Result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
