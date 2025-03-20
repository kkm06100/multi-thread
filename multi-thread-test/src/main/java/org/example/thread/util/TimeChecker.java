package org.example.thread.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.*;

public class TimeChecker {
    private static final ThreadLocal<Long> startTime;
    private static final Logger log = LoggerFactory.getLogger(TimeChecker.class);

    static {
        startTime = new ThreadLocal<>();
    }

    public TimeChecker() {
        super();
    }

    public static void start(int taskId){
        startTime.set(currentTimeMillis());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long executedTime = currentTimeMillis() - startTime.get();
        log.info("{}th thread on {} ({}ms)", taskId, Thread.currentThread().getName(), executedTime);
    }
}
