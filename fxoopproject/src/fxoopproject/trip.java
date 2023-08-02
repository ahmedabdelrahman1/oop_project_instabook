/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

import java.util.ArrayList;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class trip {
    public trip() {
    }
    
    public ArrayList getticket (adminstrator u1, String from,String to,String type)
    {
        ArrayList<Tickets> arr = new ArrayList <Tickets> ();
        for (int i=0;i<u1.List.size();i++)
        {
            
            if (u1.List.get(i).getFrom_land().equals(from)&&u1.List.get(i).getTo_land().equals(to))
            {
              
                u1.List.get(i).seattype=type;
                 arr.add( u1.List.get(i));
            }
        }
        return arr;
    }
}
