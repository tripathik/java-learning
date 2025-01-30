package com.iintelliguru.thread;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicVolatileSynchronized {
    private volatile boolean flag;
    // Volatile keyword is used, when we ensure that the particular variable may be modified by multiple threads and
    // changes made to the variable is visible to other threads immediately.
    // This also resolve the visibility problem.

    private AtomicInteger counter = new AtomicInteger(0);
    //This keyword is useful when we need to update, increment or compare the variable without data race issue
    // in thread safe environment

    public void setFlag(boolean value){
        flag = value;
    }

    public boolean getFlag(){
        return flag;
    }

    public void incrementCounter(){
        counter.incrementAndGet();
    }

    public int getCounter(){
        return counter.get();
    }

    // Using this keywords, only one thread can access the block of code at a time,
    // remaining thread will be waiting until its lock over.
    public synchronized Data getDataValue(){ // Just an example to understand the synchronized, in real world, its not a feasible way.
        Data data = new Data();
        data.setDataFlag(flag);
        data.setCount(counter.get());

        return data;
    }

    @Setter
    @Getter
    static class Data{
        private int count;
        private boolean dataFlag;
    }
}
