package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LiveLockExample {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread( ()-> {
            while(true){
                if(lock1.tryLock()){
                    try{
                        if(lock2.tryLock()){
                            try {
                                log.info("Thread-1 acquired both the locks.");
                            }finally {
                                lock2.unlock();
                            }
                        }
                    }finally {
                        lock1.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true){
                if(lock2.tryLock()){
                    try {
                        if(lock1.tryLock()){
                            try {
                                log.info("Thread2 acquired both the locks.");
                            }finally {
                                lock1.unlock();
                            }
                        }
                    }finally {
                        lock2.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
