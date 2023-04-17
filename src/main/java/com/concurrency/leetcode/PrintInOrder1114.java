package com.concurrency.leetcode;

public class PrintInOrder1114 {

    public static class Foo {

//        volatile boolean firstReady = false;
//        volatile boolean secondReady = false;

        boolean firstReady = false;
        boolean secondReady = false;
        public String result;

        public Foo() {
            result = "";
        }

//        public void first(Runnable printFirst) throws InterruptedException {
        public void first(Runnable printFirst) {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstReady = true;
        }

//        public void second(Runnable printSecond) throws InterruptedException {
        public void second(Runnable printSecond) {
            while (!firstReady)
                Thread.yield();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondReady = true;
        }

//        public void third(Runnable printThird) throws InterruptedException {
        public void third(Runnable printThird) {
            while (!secondReady)
                Thread.yield();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
