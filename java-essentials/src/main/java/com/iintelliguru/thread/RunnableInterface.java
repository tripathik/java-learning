package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableInterface implements Runnable{
    @Override
    public void run() {
        int sum = 0;
        for(int i =1; i <= 10; i++){
            sum += i;
        }
        log.info("Sum(runnable) : {}", sum);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableInterface());
        thread.start();
    }
}
