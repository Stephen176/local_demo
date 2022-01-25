package com.wz.demo;

import java.util.ArrayList;

/**
 * author: jiangtaihe
 * date: 2021/11/4
 */
public class TestArrayListGrow {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(10);
        ArrayList<Integer> list2 = new ArrayList<>(10000000);

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list1.add(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("list1 time cost:" + (t2 - t1));

        for (int i = 0; i < 10000000; i++) {
            list2.add(i);
        }
        long t3 = System.currentTimeMillis();
        System.out.println("list2 time cost:" + (t3 - t2));
    }
}
