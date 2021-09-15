package com.wz.jvm.demo;

/**
 * author: jiangtaihe
 * date: 2021/5/15
 */
public class TestGrandFather {
    class GrandFather{
        void thinking() {
            System.out.println("I am a grandfather");
        }
    }

    class Father extends GrandFather{
        void thinking() {
            System.out.println("I am a father");
        }
    }

    class Son extends Father{
        void thinking() {
            new GrandFather().thinking();
        }
    }

    public static void main(String[] args) {
        new TestGrandFather().new Son().thinking();
    }
}
