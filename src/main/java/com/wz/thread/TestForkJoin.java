package com.wz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * author: jiangtaihe
 * date: 2021/11/5
 */
public class TestForkJoin extends RecursiveTask<Integer> {

    private final int threshold = 10;
    private int first;
    private int last;

    public TestForkJoin(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestForkJoin testForkJoin = new TestForkJoin(1, 10);
        TestForkJoin testForkJoin2 = new TestForkJoin(1, 100);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = pool.submit(testForkJoin);
        ForkJoinTask<Integer> submit2 = pool.submit(testForkJoin2);

        System.out.println(submit.get());
        System.out.println(submit2.get());
    }

    @Override
    protected Integer compute() {
        int result = 0;
        int num = last - first + 1;
        if (num <= threshold) {
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            List<TestForkJoin> forkJoins = new ArrayList<>();
            int shard = num % threshold == 0 ? num / threshold : num / threshold + 1;
            for (int i = 0; i < shard; i++) {
                int endNum = i == shard - 1 ? last : first + threshold * (i + 1) - 1;
                TestForkJoin example = new TestForkJoin(first + threshold * i, endNum);
                example.fork();
                forkJoins.add(example);
            }
            for (TestForkJoin forkJoin : forkJoins) {
                result += forkJoin.join();
            }
        }
        return result;
    }
}
