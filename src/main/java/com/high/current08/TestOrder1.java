package com.high.current08;

import java.util.concurrent.CountDownLatch;

public class TestOrder1 {
    public static void main(String[] args) throws InterruptedException {
        int number = 3;
        CountDownLatch latch =  new CountDownLatch(number);
        long t1=System.currentTimeMillis();
        for(int i=0;i<3;i++){
            OrderThread1 demo = new OrderThread1(latch);
            demo.start();
        }
        latch.await();
        System.out.println("main is end,and it spent "+(System.currentTimeMillis()-t1)+" ms");
    }
}
