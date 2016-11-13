package com.blogspot.iserf.multibubblejoin;


public class Worker implements Runnable {

    private int[] arrayJob;

    public Worker(int[] arrayJob) {
        this.arrayJob = arrayJob;
    }

    @Override
    public void run() {
            IserfArrays.sort(arrayJob);
    }
}
