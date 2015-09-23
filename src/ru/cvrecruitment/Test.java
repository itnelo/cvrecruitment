package ru.cvrecruitment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ExtPackage.ExtLib;


public class Test {

    public static int[] evaluate(int[] a, int p) {
        if (a.length < 1) return a;
        int[] result = new int[a.length];
        int cpu_count = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(cpu_count);
        // ??
        return result;
    }

    public static synchronized //??

}
