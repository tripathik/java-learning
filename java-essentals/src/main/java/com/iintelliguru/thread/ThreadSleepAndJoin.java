package com.iintelliguru.thread;

// 10th Concept in Thread Learning

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadSleepAndJoin {
    public static void main(String[] args) {
        //understandThreadSleep();
        understandThreadJoin();
    }

    public static void understandThreadSleep(){
        //Used to delay the thread execution. Which means its pause the execution for a given time.
        //Useful in case of polling, animation or other.

        Thread t1 = new Thread(() -> {
            for(int i = 1; i<=4; i++){
                log.info("Record: {}, {} ", i, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    log.error("Error occurred");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i<=4; i++){
                log.info("Record: {}, {} ", i, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    log.error("Error occurred");
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void understandThreadJoin(){
        //It makes the current thread wait until the specified thread complete the execution.
        //It helps to ensure that one thread completes before the other thread starts.
        // UseCase: To wait for important task: Example ==> Loading the configuration before starting the App.

        Thread t1 = new Thread(() -> {
            for(int i = 1; i<=4; i++){
                log.info("Record: {}, {} ", i, Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    log.error("Error occurred");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i<=4; i++){
                log.info("Record: {}, {} ", i, Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    log.error("Error occurred");
                }
            }
        });
        t1.start();
        try {
            t1.join();
        }catch (Exception e){
            log.error("Error occurred.");
        }
        t2.start();
    }
}
