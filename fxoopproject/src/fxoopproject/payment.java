/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class payment implements Serializable{
    private String username;
    private double userwallet;
    public payment(String username) {
        this.username = username;
        this.userwallet=0.0;
    }
    
    public void addtowallet(double amount)
    {
       this.userwallet=this.userwallet+amount;
    }
    public boolean paywithwallet (Tickets t)
    {
        if(t.seattype=="firstclass")
        {
            if(this.userwallet>t.getFirstprice())
           {
            this.userwallet=this.userwallet-t.getFirstprice();
            return true;
           }
        }
        else if (t.seattype=="businessclass")
        {
            if(this.userwallet>t.getBusinessprice())
     
           {
            this.userwallet=this.userwallet-t.getBusinessprice();
            return true;
           }
        }
        else if (t.seattype=="economyclass")
        {
            if(this.userwallet>t.getEconomyprice())
     
           {
            this.userwallet=this.userwallet-t.getEconomyprice();
            return true;
           }
        }
        return false;
    }
    public boolean refoundtowallet (Tickets t)
    {
         if(t.seattype=="firstclass")
        {
            this.userwallet=this.userwallet+t.getFirstprice();
            return true;
        }
        else if (t.seattype=="businessclass")
        {
            
            this.userwallet=this.userwallet+t.getBusinessprice();
            return true;
        }
        else if (t.seattype=="economyclass")
        {
           
            this.userwallet=this.userwallet+t.getEconomyprice();
            return true;
        }
        return false;
    }

    public double getUserwallet() {
        return userwallet;
    }
}
