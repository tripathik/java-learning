package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataRaceAndConditionVisibilityProblem {
    private int counter;

    public void increment(){
        counter++; // not thread safe
    }

    public int getCount(){
        return counter; //not thread safe
    }

    public static void main(String[] args) throws InterruptedException {
        DataRaceAndConditionVisibilityProblem dcvp  = new DataRaceAndConditionVisibilityProblem();
        Thread t1 = new Thread(dcvp::increment);

        Thread t2 = new Thread(() -> {
            log.info("Counter Value is : {}", dcvp.getCount());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
