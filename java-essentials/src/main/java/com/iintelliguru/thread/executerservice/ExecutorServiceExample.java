package com.iintelliguru.thread.executerservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExecutorServiceExample {
    // EXECUTOR_SERVICE: ExecutorService is a framework in Java which is used for managing the threads execution efficiently.
    // => Instead of creating & managing threads manually we can use ExecutorService to manage the task
    // asynchronously using thread-pooling.

    //Used For:
    // 1. Managing thread creation and execution efficiently.
    // 2. Optimized resource utilization by reusing threads.
    // 3. Supports system overhead from creating too many threads.
    // 4. Supports various Thread Pool Strategies.
    public static void main(String[] args) {
        underStandFixedThreadPool();
        understandingCachedThreadPool();
        understandingSingleThreadPool();
        understandingScheduledThreadPool();
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
            executor.execute(()-> log.info("Task: {} is executed by Thread: {}", taskId, Thread.currentThread().getName()));
        }
        executor.shutdown();
    }


    // 2. CachedThreadPool:
    // It is used to maintain the thread dynamically as per the need or demand.
    // As per the need threads are created and also reused.
    // When there would be any unused thread, it will be terminated after some specified idle timeout.
    public static void understandingCachedThreadPool(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 1; i<=5; i++){
            final int taskId = i;
            executor.execute(() -> log.info("Task {} is executed by Thread: {}, in pool.", taskId, Thread.currentThread().getName()));
        }
    }



    // 3. SingleThreadPool:
    // Used for sequential executions of task by a single/only one thread in the pool.
    // If due to any error the thread got terminated, the new thread is created to replace it.
    // Can be used in case on any sequential execution of task.
    public static  void understandingSingleThreadPool(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i =1; i<=5; i++){
            final int taskId = i;
            executor.execute(()-> log.info("Task- {} is executed by Thread- {} in Single Thread pool.", taskId, Thread.currentThread().getName()));
        }
        executor.shutdown();
    }


    // 4. ScheduledThreadPool:
    // Used for executing the tasks at specified time or with a fixed delay between executions.
    // Maintains a pool of threads and supports scheduling tasks with methods, schedule(),
    // scheduleAtFixRate(), scheduleWithFixedDelay().
    // UseCase => Can be used,if you need to update the cache after some fixed interval of time.
    public static  void understandingScheduledThreadPool(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        Runnable task = (()-> log.info("Repeating Task executed at; {} ", System.currentTimeMillis()));


        // Schedule a task to execute after 5 seconds
        scheduler.schedule(() ->
                        task,
                5, TimeUnit.SECONDS);

        // Schedule a task to execute every 1 second, starting immediately
        scheduler.scheduleAtFixedRate(() ->
                        log.info("Scheduled Task at fixedRate"),
                0, 1, TimeUnit.SECONDS);
        scheduler.shutdown();
    }




}
