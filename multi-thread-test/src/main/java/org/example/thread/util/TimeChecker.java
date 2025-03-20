package org.example.thread.util;

import static java.lang.System.*;

public class TimeChecker {
    private static final ThreadLocal<Long> startTime;

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

        StringBuffer sb = new StringBuffer();
        sb.append(taskId)
                .append(" thread on ")
                .append(Thread.currentThread().getName())
                .append(" (")
                .append(executedTime)
                .append("ms)");

        out.println(sb);
    }
}
