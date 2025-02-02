package com.iintelliguru.thread;

public class ThreadBasic extends Thread {
    public void run() {
        System.out.println("Thread is Running..." + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadBasic threadObj = new ThreadBasic();
        threadObj.start();


        //better way of using thread.
        Thread objThread = new Thread(()-> {
            System.out.println("New thread is running..");
        });
        objThread.start();

        //most efficient way, using Runnable interface.
        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread three is running.");
            }
        };
        Thread threadObj3 = new Thread(objRunnable, "Runnable Thread");
        threadObj3.start();

        //most appropriate way of using runnable interface.
        Runnable objRunnableNew = () -> {
            System.out.println("Thread 4 is started...");
            System.out.println("Thread Name: "+ Thread.currentThread().getName());
            System.out.println("Thread State: "+ Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 4 Completed...");
        };
        Thread threadObj4 = new Thread(objRunnableNew, "Runnable Thread");
        threadObj4.start();


    }



}
