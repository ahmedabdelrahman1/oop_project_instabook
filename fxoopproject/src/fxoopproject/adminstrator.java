/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class adminstrator extends person implements Serializable {
     private String adminstorid;
     ArrayList <adminstrator> admin = new ArrayList <> ();

    public String getAdminstorid() {
        return adminstorid;
    }
     
    public adminstrator(String adminstorid) 
    {
        this.adminstorid = adminstorid;
    }

    public void create (Tickets t1)
    {
        List.add(List.size(),t1);
        map1.put(t1.getId(), t1);
    }
    public void delete (Tickets t)
    {
        List.remove(t);
        map1.remove(t.getId());
    }
   public void edit(Tickets t1,int index)
   {
      List.set(index, t1);
      map1.replace(List.get(index).getId(), t1);
      
   }
   public int getindex (Tickets t1) 
   {
       int a=0;
       for(int i=0;i<List.size();i++)
       {
           
            if(List.get(i).getId().equals(t1.getId()))
            {
                return a;
            }
            a++;
       }
       return 0;
   }
    
    @Override
   public void writetofile () 
   {
         try {
             File f = new File ("tickets.data");
             if (!f.exists())
                 f.createNewFile();
             else
             {
                 FileOutputStream fos = new FileOutputStream(f);
                 ObjectOutputStream oos=new ObjectOutputStream (fos);
                 oos.writeObject(List);
                 oos.close();
             }
             } catch (IOException ex) 
             {
             Logger.getLogger(adminstrator.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    @Override
   public void readfromfile () 
   {
         try {
             File f = new File ("tickets.data");
             if (!f.exists())
                 f.createNewFile();
             FileInputStream fis =new FileInputStream (f);
             ObjectInputStream ois = new ObjectInputStream (fis);
             List=(ArrayList<Tickets>) ois.readObject();
             for(int i=0;i<List.size();i++)
             {
                 map1.put(List.get(i).getId(), List.get(i));
             } 
         } catch (IOException | ClassNotFoundException ex) {
             Logger.getLogger(adminstrator.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
   public Tickets sreach (String id)
   {
          return map1.get(id);
   }
}
