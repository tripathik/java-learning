package com.iintelliguru.thread;

public class ThreadBasic extends Thread {
    public void run() {
        System.out.println("Thread is Running..." + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadBasic threadObj = new ThreadBasic();
        threadObj.start();
    }
}
