package com.iintelliguru.thread.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
@Slf4j
public class ForkJoinSortExample extends RecursiveAction {
    private static final int THRESHOLD = 3;
    private final int start;
    private final int end;
    private final int[] array;

    public ForkJoinSortExample(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected void compute() {
        if(end - start <= THRESHOLD){
            Arrays.sort(array, start, end);
        }
        else{
            int mid = (start + end)/2;

            ForkJoinSortExample leftTask = new ForkJoinSortExample(start, mid, array);
            ForkJoinSortExample rightTask = new ForkJoinSortExample(mid, end, array);

            invokeAll(leftTask, rightTask);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {9, 7, 3, 1, 6, 5, 8, 2, 4, 10};
        log.info("Numbers before sorting: {}", numbers);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ForkJoinSortExample(0, numbers.length, numbers));
        log.info("Numbers after sorting is done: {}", numbers);

    }
}
