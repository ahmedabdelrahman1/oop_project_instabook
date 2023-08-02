/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class seats {
     String seatname;
    boolean booked;

    public seats() {
    }

    public void setSeatname(String seatname) {
        this.seatname = seatname;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getSeatname() {
        return seatname;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean pickseat (Tickets t1,String seatnumber)
    {
        t1.seatname=seatnumber;
      if("firstclass".equals(t1.seattype))
      {
        if (seatnumber.charAt(0)=='A')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= (int)seatnumber.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==false)
            {
            t1.firstclass[i][j]=true;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='B')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= (int)seatnumber.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==false)
            {
            t1.firstclass[i][j]=true;
            return true;
            }
            else 
            {

                return false;
            }
        }
        else if (seatnumber.charAt(0)=='C')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= (int)seatnumber.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==false)
            {
            t1.firstclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='D')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= (int)seatnumber.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==false)
            {
            t1.firstclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
      }
      else if("businessclass".equals(t1.seattype))
      {
        if (seatnumber.charAt(0)=='A')
        { 
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='B')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='C')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='D')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='E')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='F')
        {
           int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.businessclass[i][j]==true)
            {
            t1.businessclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
      }
      else if("economyclass".equals(t1.seattype))
      {
        if (seatnumber.charAt(0)=='A')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='B')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='C')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='D')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='E')
        {
            int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
                
                return false;
            }
        }
        else if (seatnumber.charAt(0)=='F')
        {
             int i= seatnumber.charAt(0);
            i=(int)i-65;
            int j= seatnumber.charAt(1);
            j=(int)j-49;
            if(t1.ecnomyclass[i][j]==true)
            {
            t1.ecnomyclass[i][j]=true;
            return true;
            }
            else 
            {
               
                return false;
            }
        }
      }
        return false;
    }
    public boolean deleteseat (Tickets t1)
    {
        
      if("firstclass".equals(t1.seattype))
      {
        if (t1.seatname.charAt(0)=='A')
        {
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='B')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='C')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='D')
        {
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
      }
      else if("businessclass".equals(t1.seattype))
      {
        if (t1.seatname.charAt(0)=='A')
        { 
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='B')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='C')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='D')
        {
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='E')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='F')
        {
          int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
      }
      else if("economyclass".equals(t1.seattype))
      {
        if (t1.seatname.charAt(0)=='A')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='B')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='C')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='D')
        {
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='E')
        {
           int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
        else if (t1.seatname.charAt(0)=='F')
        {
            int i= t1.seatname.charAt(0);
            i=(int)i-65;
            int j= (int)t1.seatname.charAt(1);
            j=j-49;
            if(t1.firstclass[i][j]==true)
            {
            t1.firstclass[i][j]=false;
            return true;
            }
            else 
            {
                return false;
            }
        }
      }
        return false;
    }
}
