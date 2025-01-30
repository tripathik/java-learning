package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLockExample {
    static final Object resource1 = new Object();
    static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1){//Thread-2 can't get the access of Resource-1
                log.info("Thread-1 locked Resource-1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource2){
                    log.info("Thread-1 locked Resource-2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2){ // Thread-1 can get the access of Resource-2
                log.info("Thread-2 locked Resource-2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource1){
                    log.info("Thread-2 locked Resource-1");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
