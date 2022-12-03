/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import view.MainFrame;

/**
 *
 * @author 10
 */
public class Manager {
    LinkedList<Integer> list = new LinkedList<>();
    String filePath;
    FileWriter fileWriter = null;
    int capacity;
    int currentNum =3;
    int primeFlag =0;
    int primeCount =2;
    long startTime;
    
    public Manager(int c) throws IOException{
        capacity = c;
        filePath= MainFrame.OutputFile.getText();
        startTime = System.currentTimeMillis();
        
        list.add(1);
        list.add(2);
        fileWriter = new FileWriter(filePath);
        fileWriter.append("");
    }
    
    public void produce() throws InterruptedException{
        while (currentNum <= Integer.parseInt(MainFrame.NumberLimit.getText()) ) {
                synchronized (this)
                {
                    
                    while (list.size() == capacity){
                        System.out.println("FULL");
                        wait();}
                    for(int i=2;i<currentNum;i++){
                        if(currentNum%i==0){primeFlag=1;break;}
                    }
                    if(primeFlag==0){
                        list.add(currentNum);
                        primeCount++;
                        
                        MainFrame.LargestPrime.setText(Integer.toString(currentNum));
                        MainFrame.NumOfPrime.setText(Integer.toString(primeCount));
                        MainFrame.TimeElapsed.setText( "    " +Long.toString(System.currentTimeMillis() - startTime) + "ms");
                   
                        

                    }
                    System.out.println("Produced - " + currentNum + " Details: "+list.size() + "  : " + capacity);
                    currentNum++;
                    primeFlag=0;
                    //MainFrame.LargestPrime.setText("Test");
                    notify();


                }
            }
    }
    
    public void consume() throws InterruptedException{
        while (currentNum <= Integer.parseInt(MainFrame.NumberLimit.getText()) || !list.isEmpty()) {
                synchronized (this)
                {
                    while (list.isEmpty()){wait();}
 
                    int val = list.removeFirst(
 
                    writeIn(val);
                    System.out.println("Consumed - "+ val);

                    notify();
                }
            }
    }
    
    private void writeIn(int x){
        
        try {
            fileWriter = new FileWriter(filePath,true);
            StringBuilder line = new StringBuilder();
            line.append("\""+x+"\", \n");
            fileWriter.append(line);
            fileWriter.close();
        } catch (IOException ex) {
            System.exit(0);
        }
    }
}
