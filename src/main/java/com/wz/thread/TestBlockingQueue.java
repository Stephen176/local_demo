package com.wz.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * author: jiangtaihe
 * date: 2021/11/5
 */
public class TestBlockingQueue {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            Producer p = new Producer();
            p.start();
        }

        for (int i = 0; i < 12; i++) {
            Consumer c = new Consumer();
            c.start();
        }
    }

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(200);
                queue.put("包子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("刚刚出锅了一个包子👙");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                String take = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("吃了一个大包子🍚");
        }
    }
}
