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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class User extends person implements Serializable {
    String username;
    String userpassword;
    String nasonaltiy;
    String phonenumber;
    String adress;
    payment p ;
    ArrayList<Tickets> reserved_Tickets ;

    public User(String username, String userpassword, String nasonaltiy, String phonenumber, String adress) {
        this.username = username;
        this.userpassword = userpassword;
        this.nasonaltiy = nasonaltiy;
        this.phonenumber = phonenumber;
        this.adress = adress;
        reserved_Tickets=new ArrayList<>();
         p=new payment(username);
    }
    
     
  
      public boolean Reservation(Tickets t1)
        {
            if(p.paywithwallet(t1))
            {
          reserved_Tickets.add(reserved_Tickets.size(),t1);
          if("firstclass".equals(t1.seattype))
          t1.setNo_offirstclass(t1.getNo_offirstclass()-1); 
          else if("businessclass".equals(t1.seattype))
          t1.setNo_ofbusinessclass(t1.getNo_ofbusinessclass()-1);
          else if("economyclass".equals(t1.seattype))
          t1.setNo_ofeconomyclass(t1.getNo_ofeconomyclass()-1);
          for(int i=0;i<List.size();i++)
          {
              if (t1.getId().equals(List.get(i).getId()))
                  List.set(i, t1);
          }
          return true;
            }
            else 
                return false;
         
        }
      
      
      
        public boolean Cancellation(Tickets t1)
        {
           if(p.refoundtowallet(t1))
            {
          reserved_Tickets.add(reserved_Tickets.size(),t1);
          if("firstclass".equals(t1.seattype))
          t1.setNo_offirstclass(t1.getNo_offirstclass()-1); 
          else if("businessclass".equals(t1.seattype))
          t1.setNo_ofbusinessclass(t1.getNo_ofbusinessclass()-1);
          else if("economyclass".equals(t1.seattype))
          t1.setNo_ofeconomyclass(t1.getNo_ofeconomyclass()-1);
          for(int i=0;i<List.size();i++)
          {
              if (t1.getId().equals(List.get(i).getId()))
                  List.set(i, t1);
          }
          return true;
            }
            else 
                return false;
     
        }
            
        

        public ArrayList<Tickets> display()
        {
            ArrayList<Tickets> r = new ArrayList <>();
            for(int i=0;i<reserved_Tickets.size();i++)
            {
                r.add(reserved_Tickets.get(i));
            }
            return r;
        }
       
    /**
     *
     * @throws java.io.IOException
     */
    @Override
        public void writetofile() 
        {
        try {
            File f = new File (username);
            if (!f.exists())
                f.createNewFile();
            else
            {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos=new ObjectOutputStream (fos);
                oos.writeObject(reserved_Tickets);
                oos.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        @Override
         public void readfromfile () 
        {
        try {
            File f = new File (username);
            if (!f.exists())
                f.createNewFile();
            else
            {
                FileInputStream fis =new FileInputStream (f);
                ObjectInputStream ois = new ObjectInputStream (fis);
                reserved_Tickets=(ArrayList<Tickets>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getNasonaltiy() {
        return nasonaltiy;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setNasonaltiy(String nasonaltiy) {
        this.nasonaltiy = nasonaltiy;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    

}
