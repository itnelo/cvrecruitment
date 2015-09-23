package ru.cvrecruitment;

import java.util.concurrent.Callable;
import ExtPackage.ExtLib;

public class EvalTask implements Callable<EvalTaskResult> {

    private int input_index;
    private int input_value;

    public EvalTask(int index, int value) {
        this.input_index = index;
        this.input_value = value;
    }

    @Override
    public EvalTaskResult call() {
        return new EvalTaskResult(input_index, ExtLib.eval(input_value, ));
    }

}
