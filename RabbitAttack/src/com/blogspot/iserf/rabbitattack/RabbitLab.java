
package com.blogspot.iserf.rabbitattack;

/**
 *
 * @author alex
 */
public class RabbitLab {
    
    static public int rabbitCount = 0;

    public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();
    }

}
