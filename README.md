测试小案例：实现线程的顺序执行  
方案：(1)使用countdownlatch方式  
(2)使用thread与join方式实现  
  
第一种方案  
```java
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
```
```java
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
```

   
第二种方案  
```java
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
```
```java
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
```