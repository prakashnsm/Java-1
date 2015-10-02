/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package trycatchexample;
import java.io.*;

/**
 *
 * @author Preon
 */
public class TryCatchExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            int a[] = new int[2];
            System.out.println("Access element three: " + a[3]);
          }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown :" + e);
          }
            System.out.println("Out of the block");
            
         try{
             file = new FileInputStream(fileName);
             x = (byte) file.read();
         }catch(IOException i){
             i.printStackTrace();
             return -1;
         }catch(FileNotFoundException f) //Not valid!
         {
             f.printStackTrace();
             return -1;
         }
             
    }
    
}
