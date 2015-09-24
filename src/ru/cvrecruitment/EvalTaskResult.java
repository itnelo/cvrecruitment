package ru.cvrecruitment;

public class EvalTaskResult {
    public int index;
    public int value;

    public EvalTaskResult(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
