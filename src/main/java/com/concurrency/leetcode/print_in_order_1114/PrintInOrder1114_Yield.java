package com.concurrency.leetcode.print_in_order_1114;

public class PrintInOrder1114_Yield {

    public static class Foo {

        volatile boolean firstReady = false;
        volatile boolean secondReady = false;

        public String result = "";

        public Foo() {
        }

        public void first(Runnable printFirst) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstReady = true;
        }

        public void second(Runnable printSecond) {
            while (!firstReady)
                Thread.yield();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondReady = true;
        }

        public void third(Runnable printThird) {
            while (!secondReady)
                Thread.yield();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
