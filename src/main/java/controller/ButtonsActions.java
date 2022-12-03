/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.ConsumeThread;
import Model.Manager;
import Model.ProduceThread;
import com.mycompany.udacity_project_sales_invoice_generator.Prime_Generator_Operating_Systems;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.MainFrame;

/**
 *
 * @author dell
 */
public class ButtonsActions implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "SP" -> {
            try {
                Prime_Generator_Operating_Systems.manage = new Manager(Integer.parseInt(MainFrame.Buffer.getText()));
            } catch (IOException ex) {
                Logger.getLogger(ButtonsActions.class.getName()).log(Level.SEVERE, null, ex);
            }
                ProduceThread t1 = new ProduceThread(Prime_Generator_Operating_Systems.manage);
                ConsumeThread t2 = new ConsumeThread(Prime_Generator_Operating_Systems.manage);
                t1.start();
                t2.start();
              /*  
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ButtonsActions.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ButtonsActions.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            }
               
        }
    }

}
