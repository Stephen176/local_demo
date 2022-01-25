package com.wz.demo;

/**
 * author: jiangtaihe
 * date: 2021/11/3
 */
public class IntDemo {
    public static void main(String[] args) {
//        test1();
    }

    private static void test1() {
        String s = new String("1");
        String s2 = "1";
        String sr = s.intern();
        System.out.println(s == s2);
        System.out.println(sr == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String s3r = s3.intern();
        System.out.println(s3 == s4);
        System.out.println(s4 == s3r);
    }
}
