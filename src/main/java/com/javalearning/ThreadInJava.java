package com.javalearning;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadInJava {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->count.incrementAndGet());
        Thread t2 = new Thread(()->count.addAndGet(2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.get());
    }
}
