/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author nat
 */
public class MADmidterms {
    
    public static void main(String[] args){
        ArrayList<String> words= new ArrayList<>();
        ArrayList<Double> numbers = new ArrayList<>();
        try{
            File f = new File("/Users/tea/Desktop/PADILLA.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                
                String[] details = data.split(";");
                String word = details[0];
                double number = Double.parseDouble(details[1]);
                
                words.add(word);
                numbers.add(number);
            }
            
            
            String[] w = new String[words.size()];
            for (int i = 0; i < words.size();i++) { 
                w[i] = words.get(i);
            }
            
            
            for (int i = 0; i < w.length; i++) {
                for(int j = i + 1; j < w.length; j++) {
                    String tempi = w[i];
                    String tempj = w[j];

                    if(tempj.length() < tempi.length()) {
                        w[i] = w[j];
                        w[j] = tempi;
                    }
                }
            }
            
            
            double[] num = new double[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) 
            {
                num[i] = numbers.get(i);
            }
            
            
            for (int i = 0; i < numbers.size(); i++) 
            {
                for (int j = i + 1; j < numbers.size(); j++) 
                {
                    if (num[i] < num[j]) 
                    {
                        double temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                    }
                }
            }
            
            
            PrintStream var = System.out;
            PrintStream var2 = new PrintStream("/Users/tea/Desktop/NATASJA.txt");
            System.setOut(var2);
            int i = w.length-1;
            int j= num.length-1;
            int k=0;
            int l=0;
            do{
                i--;
                j--;
                System.out.println(w[k++] + "\t" + num[l++]);
            }
            while(i >= 0 || j >= 0);
            
        }
        catch(Exception e){
            System.out.println("error");
        }
        
    }
    
}
