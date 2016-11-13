/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.iserf.rabbitattack;

import java.util.logging.Level;
import java.util.logging.Logger;

class RabbitPrinter implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
            
            RabbitLab.rabbitCount++;
            System.out.println(RabbitLab.rabbitCount);
            
            
            new Thread(new RabbitPrinter()).start();
            new Thread(new RabbitPrinter()).start();
        } catch (InterruptedException ex) {
            Logger.getLogger(RabbitPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
}