package com.wz.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: jiangtaihe
 * date: 2021/11/4
 */
public class TestConcurrent {
    private static int m = 0;
    private static AtomicInteger n = new AtomicInteger();

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    m++;
                    n.incrementAndGet();
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach(thread -> thread.start());
        System.out.println("start all threads >>>");

        // 此处等待 所有线程计算完毕，再执行下面的打印
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m);
        System.out.println(n);
    }
}
