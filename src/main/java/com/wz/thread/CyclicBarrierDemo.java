package com.wz.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("大伙儿今儿吃的很high!@#$%^&*("));
        for (int i = 0; i < 8; i++) {
            new MyThread(barrier).start();
        }
    }

    static class MyThread extends Thread {
        CyclicBarrier barrier;

        public MyThread(CyclicBarrier barrier) {
            this.barrier=barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + "到达了聚餐地点--客来悦");
                barrier.await();
                System.out.println(getName() + "喝的有点多~~~");

                Thread.sleep(3000);
                System.out.println(getName() + "到达了聚餐地点--格兰云天大酒店");
                barrier.await();
                System.out.println(getName() + "散伙饭~~~");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
