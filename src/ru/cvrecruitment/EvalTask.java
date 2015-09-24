package ru.cvrecruitment;

import java.util.concurrent.Callable;
import ExtPackage.ExtLib;

public class EvalTask implements Callable<EvalTaskResult> {

    private int input_index;
    private int input_value;
    private int input_p;

    public EvalTask(int index, int value, int p) {
        this.input_index = index;
        this.input_value = value;
        this.input_p = p;
    }

    @Override
    public EvalTaskResult call() {
        int output_value;
        try {
            output_value = evalImpl();
        } catch (Exception e) {
            // Example 1: new_value = 0 && logger call
            // Example 2: new_value = input_value (no changes apply)
            output_value = input_value;
            //log(...);
        }
        return new EvalTaskResult(input_index, output_value);
    }

    private int evalImpl() {
        return ExtLib.eval(input_value, input_p);
    }

}
