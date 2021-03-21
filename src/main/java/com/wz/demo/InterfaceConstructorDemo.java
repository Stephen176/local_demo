package com.wz.demo;

public class InterfaceConstructorDemo {

    public static void main(String[] args) {

    }

    abstract class A {
        public A() {

        }
        abstract void m();
    }

    interface I {
      void test();
    }

    class B extends A implements I{

        @Override
        void m() {

        }

        @Override
        public void test() {

        }
    }
}
