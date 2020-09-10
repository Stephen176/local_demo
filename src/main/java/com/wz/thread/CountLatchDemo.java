package com.wz.thread;

import java.util.concurrent.CountDownLatch;

public class CountLatchDemo {
    public static void main(String[] args) throws InterruptedException{
//        test1();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 9; i++) {
            new MyThread2(latch).start();
        }

        System.out.println("start ----");
        Thread.sleep(3000);
        latch.countDown();
    }

    private static void test1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(9);

        for (int i = 0; i < 9; i++) {
            new MyThread(latch).start();
        }

        System.out.println("start");
        latch.await();
        System.out.println("all thread is done!");
    }

    static class MyThread2 extends Thread {
        CountDownLatch latch;
        public MyThread2(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                latch.await();
                System.out.println(getName()+" is done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   static class MyThread extends Thread {
        CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

       @Override
       public void run() {
           try {
               Thread.sleep(5000);
               System.out.println(getName()+" is done");
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               latch.countDown();
           }
       }
   }
}
