package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        final int numberOfThreads = 20_000;
        List<Thread> threadList = new ArrayList<>();

        Runnable objectRunnable = new Runnable() {
            @Override
            public void run() {
                log.info("Fetching Data From API...");

                try {
                    Thread.sleep(10000);// Simulate the time taken to fetch the data.
                }catch (Exception e){
                    log.error("Thread interrupted, Exception: {}",e);
                }
                log.info("Data have been fetched from API successfully...");
            }

        };

        for(int i =0; i <numberOfThreads; i++){
            Thread thread = Thread.ofVirtual().unstarted(objectRunnable);
            //thread.setDaemon(true);
            thread.setName("Thread "+i);
            thread.start();
            String str = String.format("Thread number %s",i);
            log.info(str);
            threadList.add(thread);
        }

        for(Thread thread: threadList){
            thread.join();
            log.info("Completed Thread: {}", thread);

        }
    }
}
