/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10
 */
public class ConsumeThread extends Thread{
    
    Manager manage;
    public ConsumeThread(Manager m) { this.manage = m;}
    
    @Override
    public void run() {
        try {
            manage.consume();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConsumeThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
