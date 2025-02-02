package com.iintelliguru.thread.executerservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExecutorServiceExample {
    // EXECUTER_SERVICE: ExecuterService is a framework in Java which is used for managing the threads execution efficiently.
    // => Instead of creating & managing threads manually we can use ExecuterService to manage the task
    // asynchronously using thread-pooling.

    //Used For:
    // 1. Managing thread creation and execution efficiently.
    // 2. Optimized resource utilization by reusing threads.
    // 3. Supports system overhead from creating too many threads.
    // 4. Supports various Thread Pool Strategies.
    public static void main(String[] args) {
        underStandFixedThreadPool();
    }


    //Thread Pools:
    // 1. FixedThreadPool:
    // Maintain a fixed number of thread in the thread pool.
    // If a task is submitted while all the threads are busy, it is queued until any threads from pool
    // become available.
    // Can be used in the case of if task with the predictable threads.
    public static void underStandFixedThreadPool(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i<5; i++){
            final int taskId = i;
            executor.execute(()->{
                log.info("Task: {} is executed by Thread: {}", taskId, Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
