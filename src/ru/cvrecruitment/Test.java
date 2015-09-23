package ru.cvrecruitment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ExtPackage.ExtLib;


public class Test {

    //private static

    public static int[] evaluate(int[] a, int p) {
        if (a.length < 1) return a;
        int[] result = new int[a.length];
        int cpu_count = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(cpu_count);
        for (int i = 0; i < a.length; ++i) {
            es.execute(new EvalTask());
        }
        es.shutdown(); // Wait until all tasks done
        try {
            es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // log problem
        }
        return result_???;
    }

    public static synchronized

}
