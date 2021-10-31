package com.high.current08;

public class OrderThread2 extends Thread{

    @Override
    public void run(){
        System.out.println("Thread:"+Thread.currentThread().getName()+" is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:"+Thread.currentThread().getName()+" is end");
    }
}
