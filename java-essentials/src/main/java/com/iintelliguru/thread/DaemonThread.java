package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonThread {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while(true){
                log.info("Daemon Thread is running..");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    log.error("Error Occurred while executing the process.", e);
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        log.info("Main thread is running...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Main thread is finishing...");
    }
}
