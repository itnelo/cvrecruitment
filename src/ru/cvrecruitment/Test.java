package ru.cvrecruitment;

import java.util.concurrent.*;

public class Test {

    public static int[] evaluate(int[] a, int p) {
        if (a.length < 1) return a;
        int[] result = new int[a.length];
        final int cpuCount = Runtime.getRuntime().availableProcessors();
        final ExecutorService pool = Executors.newFixedThreadPool(cpuCount);
        final CompletionService<EvalTaskResult> completionService = new ExecutorCompletionService<EvalTaskResult>(pool);
        for (int i = 0; i < a.length; ++i) {
            completionService.submit(new EvalTask(i, a[i]));
        }
        pool.shutdown(); // Wait until all tasks done
        try {
            while (!pool.isTerminated()) {
                final Future<EvalTaskResult> future = completionService.take();
                EvalTaskResult resultPart = future.get();
                result[ resultPart.index ] = resultPart.value;
            }
        } catch (ExecutionException | InterruptedException ex) {
            // do something
        }
        return result;
    }

    public static void main(String... args) {

        ;

    }

}
