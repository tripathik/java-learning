package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YieldMethodExample {
    public static void main(String[] args) {
        Runnable r = () -> {
            int counter =0;
            while(counter<2){
               log.info("Running Thread is: {}", Thread.currentThread().getName());
               counter++;
               Thread.yield();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}
