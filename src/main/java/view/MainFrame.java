/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author dell
 */
public class MainFrame extends JFrame{
    public static JTextField NumberLimit = new JTextField();
    public static JTextField Buffer = new JTextField();
    public static JTextField OutputFile = new JTextField();
    public static JLabel LargestPrime = new JLabel("-1");
    public static JLabel NumOfPrime = new JLabel("-1");
    public static JLabel TimeElapsed = new JLabel("-1");
  
    
    public MainFrame(String name){
        //creating the Home Frame.
        super(name);
        setLocation(0,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GREEN);
        setLayout(new GridLayout(2,1));
        
        //creating all the controller objects to add as event listeners;
        ButtonsActions buttonsListener = new ButtonsActions();

        
        
        //creating the left panel and its sub containers with mockdata.
        JPanel leftPanel=new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(new Insets(10, 15, 10, 15)));
        JPanel leftInputsPanel = new JPanel();
        leftInputsPanel.setLayout(new GridLayout(4,2));
        leftInputsPanel.add(NumberLimit);
        leftInputsPanel.add(new JLabel("N"));
        leftInputsPanel.add(Buffer);
        leftInputsPanel.add(new JLabel("Buffer Size"));
        leftInputsPanel.add(OutputFile);
        leftInputsPanel.add(new JLabel("Output File"));
        leftPanel.add(leftInputsPanel);
        JButton createBtn=new JButton("Start Producer");
        createBtn.setActionCommand("SP");
        createBtn.addActionListener(buttonsListener);
        leftPanel.add(createBtn);
        this.add(leftPanel); 
        
        
        //creating the right panel and its sub container with mock data.
        JPanel rightPanel=new JPanel(); 
        
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(new Insets(10, 15, 10, 15)));

        JPanel rightInputsPanel = new JPanel();
        rightInputsPanel.setLayout(new GridLayout(3,2));
        rightInputsPanel.add(new JLabel("the largest prime number"));
        rightInputsPanel.add(LargestPrime);
        rightInputsPanel.add(new JLabel("# of prime generated"));
        rightInputsPanel.add(NumOfPrime);
        rightInputsPanel.add(new JLabel("time elapsed since process starting"));
        rightInputsPanel.add(TimeElapsed);
        rightPanel.add(rightInputsPanel);
        this.add(rightPanel);

        
        this.pack();
    }
    
}
