package com.wz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * author: jiangtaihe
 * date: 2021/11/5
 */
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                    Thread.sleep(50);
                }
                return result;
            }
        });

        Thread computeThread = new Thread(task);
        computeThread.start();
        // It will block the execution of subsequent code
        System.out.println(task.get());
        System.out.println("......");
    }
}
