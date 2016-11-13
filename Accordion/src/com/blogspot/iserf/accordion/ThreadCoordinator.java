package com.blogspot.iserf.accordion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ThreadCoordinator implements Runnable {

    public ThreadCoordinator() {

    }

    @Override
    public void run() {

        for (int k = 0; k < 10; k++) {
            try {
                // A + B
                Runnable printerA = new PrintRunnable("A   .", 100);
                Thread threadA = new Thread(printerA);
                threadA.start();

                Runnable printerB = new PrintRunnable(".   B", 99);
                Thread threadB = new Thread(printerB);
                threadB.start();

                threadA.join();
                threadB.join();

                System.out.println("-----");

                // C
                Runnable printerC = new PrintRunnable("  C", 100);
                Thread threadC = new Thread(printerC);
                threadC.start();
                threadC.join();

                System.out.println("-----");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
