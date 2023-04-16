package com.concurrency.jcip.chapter_1.paragraph_3;

public class UnsafeSequence {
    public int value;

    public UnsafeSequence() {
        this.value = 0;
    }

    public int getNext() {
        return value++;
    }
}

