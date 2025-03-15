package com.cnkonica.demo.config.trace;

import java.util.concurrent.Callable;

public class TraceIdContext {
    private static final ThreadLocal<String> TRACE_ID_HOLDER = new ThreadLocal();

    public TraceIdContext() {
    }

    public static String get() {
        return (String)TRACE_ID_HOLDER.get();
    }

    public static void set(final String traceId) {
        TRACE_ID_HOLDER.set(traceId);
    }

    public static void remove() {
        TRACE_ID_HOLDER.remove();
    }

    public static Runnable transfer(final Runnable action) {
        String traceId = get();
        return () -> {
            set(traceId);

            try {
                action.run();
            } finally {
                remove();
            }

        };
    }

    public static <T> Callable<T> transfer(final Callable<T> func) {
        String traceId = get();
        return () -> {
            set(traceId);

            T var2;
            try {
                var2 = func.call();
            } finally {
                remove();
            }

            return var2;
        };
    }
}
