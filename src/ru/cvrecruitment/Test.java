package ru.cvrecruitment;

import java.util.concurrent.*;

public class Test {

    public static int[] evaluate(int[] data, int p) {
        if (data.length < 1) return data;
        final int[] result = new int[data.length];
        final int cpuCount = Runtime.getRuntime().availableProcessors();
        final ExecutorService pool = Executors.newFixedThreadPool(cpuCount);
        final CompletionService<EvalTaskResult> completionService = new ExecutorCompletionService<EvalTaskResult>(pool);
        for (int i = 0; i < data.length; ++i) {
            completionService.submit(new EvalTask(i, data[i], p));
        }
        pool.shutdown(); // Wait until all tasks done
        try {
            while (!pool.isTerminated()) {
                final Future<EvalTaskResult> future = completionService.take();
                EvalTaskResult resultPart = future.get();
                result[ resultPart.index ] = resultPart.value;
            }
        } catch (ExecutionException | InterruptedException e) {
            // do something
        }
        return result;
    }

    public static void main(String... args) {

        int[] arr = {1, 2, 3};

        System.out.println(Test.evaluate(arr, 2).toString());

    }

}
