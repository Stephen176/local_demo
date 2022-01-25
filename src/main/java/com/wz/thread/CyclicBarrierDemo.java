package com.wz.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
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
                System.out.println(getName() + "到达了聚餐地点--格兰云天");
                Thread.sleep(500);
                barrier.await();
                System.out.println(getName() + "吃的很high");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
