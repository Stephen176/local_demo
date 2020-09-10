package com.wz.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);

        for (int i = 0; i < 8; i++) {
            new SemaphoreThread(semaphore).start();
        }
    }

    static class SemaphoreThread extends Thread {
        Semaphore semaphore;

        public SemaphoreThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(getName() + "acquire");
                Thread.sleep(2000);
                semaphore.release();
                System.out.println(getName() + "release");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
