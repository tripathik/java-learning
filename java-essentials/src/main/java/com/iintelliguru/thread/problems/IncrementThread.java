package com.iintelliguru.thread.problems;


import com.iintelliguru.thread.problems.dto.Counter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncrementThread extends Thread{
    //1. Write a Java Program which will create and start multiple threads that increment
    // a shared counter variable concurrently.

    private Counter counter;
    private int incrementPerThreads;
    public IncrementThread(Counter counter, int incrementPerThreads){
        this.counter = counter;
        this.incrementPerThreads = incrementPerThreads;
    }
    @Override
    public void run(){
        for(int i =0; i<incrementPerThreads; i++){
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        int numThreads = 6;
        int incrementsPerThread = 10000;
        IncrementThread[] threads = new IncrementThread[numThreads];
        for(int i = 0; i < numThreads; i++){
            threads[i] = new IncrementThread(counter1, incrementsPerThread);
            threads[i].start();
        }
        try {
            for(IncrementThread thread: threads){
                thread.join();
            }
        }catch (Exception e){
            log.error("Exception occurred: ",e);
        }
        log.info("Final Count: {}", counter1.getCount());
    }
}
