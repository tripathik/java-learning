package com.iintelliguru.thread;

public class WaitNotifyExample {
    private static final Object lock = new Object(); // Object used as a monitor for synchronization
    private static boolean condition = false; // Shared condition variable

    public static void main(String[] args) {
        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            synchronized (lock) {
                while (!condition) { // Wait until condition is true
                    try {
                        lock.wait(); // Wait for notification
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Condition is true, consume the resource
                System.out.println("Consumer: Resource consumed");
            }
        });

        // Producer thread
        Thread producerThread = new Thread(() -> {
            // Produce the resource
            System.out.println("Producer: Resource produced");
            synchronized (lock) {
                condition = true; // Set condition to true
                lock.notify(); // Notify waiting threads
            }
        });

        // Start consumer and producer threads
        consumerThread.start();
        producerThread.start();
    }
}
