package com.high.current08;

public class TestOrder2 {
     public static void main(String[] args) throws InterruptedException {


        OrderThread2 thread1 = new OrderThread2();
        OrderThread2 thread2 = new OrderThread2();
        OrderThread2 thread3 = new OrderThread2();
        long t1=System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("main is end,and it spent "+(System.currentTimeMillis()-t1)+" ms");
     }
}
