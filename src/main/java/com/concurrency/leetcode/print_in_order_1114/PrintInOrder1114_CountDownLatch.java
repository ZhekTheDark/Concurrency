package com.concurrency.leetcode.print_in_order_1114;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder1114_CountDownLatch {

    public static class Foo {

        private final CountDownLatch l1 = new CountDownLatch(1);
        private final CountDownLatch l2 = new CountDownLatch(1);

        public String result = "";

        public Foo() {
        }

        public void first(Runnable printFirst) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            l1.countDown();
        }

        public void second(Runnable printSecond) {
            try {
                l1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            l2.countDown();
        }

        public void third(Runnable printThird) {
            try {
                l2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
