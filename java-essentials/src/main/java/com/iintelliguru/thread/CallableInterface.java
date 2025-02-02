package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CallableInterface implements Callable<Integer> {
    @Override
    public Integer call(){
        int sum = 0;
        for(int i = 1; i<=10; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new CallableInterface());

        log.info("Sum(Callable): {}", result.get());
    }
}
