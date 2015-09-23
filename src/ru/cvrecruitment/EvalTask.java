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
        return new EvalTaskResult(input_index, (int)ExtLib.eval(input_value, input_p));
    }

}
