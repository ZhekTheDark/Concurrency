package com.concurrency.jcip.chapter_3.paragraph_1;

public class NoVisibility {

    public static boolean ready;
    public static int number;

    public static void t1() {
        number = 42;
        ready = true;
    }

    public static int t2() {
        while (!ready)
            Thread.yield();
        return number;
    }

//    public boolean ready;
//    public int number;
//
//    public void t1() {
//        number = 42;
//        ready = true;
//    }
//
//    public int t2() {
//        while (!ready)
//            Thread.yield();
//        return number;
//    }
}
