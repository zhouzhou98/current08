package com.high.current08;

import java.util.concurrent.CountDownLatch;

public class OrderThread1 extends Thread {

    private CountDownLatch latch;

    public OrderThread1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + " is end");
        latch.countDown();
    }
}
