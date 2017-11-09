package com.github.azdrachak.homework04;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

class MemoryLeaker {
    private ArrayList<String> arr;
    private int size;

    MemoryLeaker(final int size) {
        this.size = size;
        arr = new ArrayList<>(this.size);
    }

    @SuppressWarnings("unused")
    MemoryLeaker() {
        new MemoryLeaker(1_000_000);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    void leak() throws InterruptedException {
        while (true) {
            for (int i = 0; i < this.size; i++) {
                this.arr.add(new String(new char[0]));
            }
            for (int i = 0; i < this.arr.size(); i++) {
                if (i % 2 == 0) {
                    this.arr.remove(i);
                }
            }
            sleep(5000);
        }
    }
}
