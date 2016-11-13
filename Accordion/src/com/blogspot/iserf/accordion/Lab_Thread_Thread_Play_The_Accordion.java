
package com.blogspot.iserf.accordion;


public class Lab_Thread_Thread_Play_The_Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            // A + B
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();
            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();
            // C
            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            printerC.run();
            System.out.println("-----");
        }
    }
}