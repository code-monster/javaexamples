package com.blogspot.iserf.accordion;

/**
 *
 * @author alex
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadCoordinator threadCoordinator = new ThreadCoordinator();
        Thread threadMain = new Thread(threadCoordinator);
        threadMain.start();
        threadMain.join();

    }

}
