package com.concurrency.leetcode._1114_print_in_order;

public class PrintInOrder1114_SynchronizedBlock {

    public static class Foo {

        private String mutex = "";
        private int counter = 1;

        public String result = "";

        public Foo() {
        }

        public void first(Runnable printFirst) {
            boolean loop = true;
            while (loop) {
                synchronized (mutex) {
                    if (counter == 1) {
                        // printFirst.run() outputs "first". Do not change or remove this line.
                        printFirst.run();
                        ++counter;
                        loop = false;
                    }
                }
            }
        }

        public void second(Runnable printSecond) {
            boolean loop = true;
            while (loop) {
                synchronized (mutex) {
                    if (counter == 2) {
                        // printSecond.run() outputs "second". Do not change or remove this line.
                        printSecond.run();
                        ++counter;
                        loop = false;
                    }
                }
            }
        }

        public void third(Runnable printThird) {
            boolean loop = true;
            while (loop) {
                synchronized (mutex) {
                    if (counter == 3) {
                        // printThird.run() outputs "third". Do not change or remove this line.
                        printThird.run();
                        ++counter;
                        loop = false;
                    }
                }
            }
        }
    }
}
