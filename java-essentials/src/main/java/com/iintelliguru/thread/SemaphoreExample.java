package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
@Slf4j
public class SemaphoreExample {

    private final Semaphore semaphore;

    public SemaphoreExample(int slots){
        semaphore = new Semaphore(slots);
    }

    public void parkCar(String carName){
        try {
            log.info("{} is trying to park..", carName);
            semaphore.acquire();
            log.info("{} has parked.", carName);
            Thread.sleep(2000);
            log.info("{} is leaving... ", carName);
            semaphore.release();
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }
    }

    public static void main(String[] args) {
        SemaphoreExample lot = new SemaphoreExample(3);
        Runnable car = () -> {
            String carName = Thread.currentThread().getName();
            lot.parkCar(carName);
        };

        for(int i =1; i<=6; i++){
            new Thread(car, "Car"+i).start();
        }
    }
}
