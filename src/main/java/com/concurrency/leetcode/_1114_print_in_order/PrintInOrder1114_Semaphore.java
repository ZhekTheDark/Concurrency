package com.concurrency.leetcode._1114_print_in_order;

import java.util.concurrent.Semaphore;

public class PrintInOrder1114_Semaphore {

    public static class Foo {

        private final Semaphore s1 = new Semaphore(0);
        private final Semaphore s2 = new Semaphore(0);

        public String result = "";

        public Foo() {
        }

        public void first(Runnable printFirst) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            s1.release();
        }

        public void second(Runnable printSecond) {
            try {
                s1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            s2.release();
        }

        public void third(Runnable printThird) {
            try {
                s2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
