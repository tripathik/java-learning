package com.iintelliguru.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ProducerConsumerProblem {
    private static final int BUFFER_SIZE = 10;
    private static BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        producerThread.start();
        consumerThread.start();

    }

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> buffer;

        public Producer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                int value = 0;
                while (true) {
                    log.info("Produced Data: {}", value);
                    buffer.put(value);
                    value++;
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                log.error("Producer Interrupted, Exception: ", e);
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> buffer;

        public Consumer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {

                while (true) {
                    int consumedValue = buffer.take();
                    log.info("Consumed Data: {}", consumedValue);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Consumer Interrupted, Exception: ", e);
            }
        }
    }
}
