package ru.cvrecruitment;

import java.util.Arrays;
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
        pool.shutdown();
        try {
            for (int i = 0; i < data.length; ++i) {
                EvalTaskResult resultPart = completionService.take().get();
                System.out.println(resultPart.index + ":" + resultPart.value);
                result[ resultPart.index ] = resultPart.value;
            }
        } catch (ExecutionException | InterruptedException e) {
            // do something
        }
        return result;
    }

    public static void main(String... args) {

        int[] arr = {2, 3, 4};

        System.out.println(Arrays.toString(Test.evaluate(arr, 2)));

    }

}
