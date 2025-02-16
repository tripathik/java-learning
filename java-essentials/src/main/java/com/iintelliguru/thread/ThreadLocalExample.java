package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        int userId1 = 1000;
        int userId2 = 2000;

        Thread thread1 = new Thread(() -> {
            log.info("Started Thread for: {}", userId1);
            threadLocal.set(userId1);
            //Any operation(database logic, etc.)
            log.info("Completed the logic for Thread, {}", threadLocal.get());

            threadLocal.remove();
            log.info("Removed: {}" , threadLocal.get());

        });

        Thread thread2 = new Thread(() -> {
            log.info("Started Thread2 for: {}", userId1);
            threadLocal.set(userId1);
            //Any operation(database logic, etc.)
            log.info("Completed the logic for Thread2, {}", threadLocal.get());

            threadLocal.remove();
            log.info("Removed: {}" , threadLocal.get());

        });

        thread1.start();
        thread2.start();


        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread objectThread3 = new Thread(()->{
            inheritableThreadLocal.set("IntelliGuru");
            threadLocal.set(123);// will not be accessible in child thread

            Thread objectThread4 = new Thread(() ->{
                log.info("Accessing the Variable from parent thread to chile thread : {}", inheritableThreadLocal.get());
            });

            objectThread4.start();

            inheritableThreadLocal.remove();
        });

        objectThread3.start();
    }
}
