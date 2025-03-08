package com.iintelliguru.thread.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 5;

    public ForkJoinExample(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        if(end-start <= THRESHOLD){
            int sum = 0;
            for(int i = start; i<end; i++){
                sum += array[i];
            }
            return sum;
        }
        int mid = (start + end)/2;

        ForkJoinExample leftSumTask = new ForkJoinExample(array, start, mid);
        ForkJoinExample rightSumTask = new ForkJoinExample(array, mid, end);


        //leftSumTask.fork();  // Run left task asynchronously
        //int rightResult = rightSumTask.compute();  // Compute right task directly
        //int leftResult = leftSumTask.join();

        leftSumTask.fork();
        rightSumTask.fork();
        return leftSumTask.join() + rightSumTask.join();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Create a ForkJoinPoll with the default parallelism level
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int result = pool.invoke(new ForkJoinExample(array, 0, array.length));
        log.info("Sum: {}", result);

    }
}
