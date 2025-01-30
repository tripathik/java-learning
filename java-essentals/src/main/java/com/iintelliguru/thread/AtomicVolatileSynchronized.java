package com.iintelliguru.thread;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicVolatileSynchronized {
    private volatile boolean flag;
    private AtomicInteger counter = new AtomicInteger(0);

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
