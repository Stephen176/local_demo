package com.wz.jvm.demo;

/**
 * author: jiangtaihe
 * date: 2021/5/15
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human human) {
        System.out.println("hello,human!");
    }

    public void sayHello(Man man) {
        System.out.println("hello,man!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello,woman!");
    }

    public static void main(String[] args) {
        test1();
        System.out.println("-------------");
        test2();
    }

    public static void test1() {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

    public static void test2() {
        Man man = new Man();
        Woman woman = new Woman();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
