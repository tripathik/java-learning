package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class StarvationExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = ()-> {
            while(true){
                lock.lock();
                try {
                    log.info("Running Thread Name: {}", Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        log.error("Some Error Occurred, Exception : ", e);
                    }
                }finally {
                    lock.unlock();
                }
            }
        };
        Thread highPriorityThread = new Thread(task);
        Thread lowPriorityThread = new Thread(task);

        highPriorityThread.setPriority(Thread.MIN_PRIORITY);
        lowPriorityThread.setPriority(Thread.MAX_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}
