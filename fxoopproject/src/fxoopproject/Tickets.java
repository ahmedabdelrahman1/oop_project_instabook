/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

import java.io.Serializable;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class Tickets implements Serializable  {
   private String Id;
private String from_land;
private String to_land;
private String namecompany;
private String date;
private int no_offirstclass;
private int no_ofbusinessclass;
private int no_ofeconomyclass;
private double firstprice;
private double businessprice;
private double economyprice;
 boolean [][] firstclass ;
 boolean [][] businessclass;
 boolean [][] ecnomyclass;
 String seatname;
 String seattype;

public Tickets ()
{
}

public Tickets(String id ,String from_land, String to_land, String namecompany, String date,int no_offirstclass,int no_ofbusinessclass ,int no_ofeconomyclass ,double firstprice,double businessprice,double economyprice) {

 this.Id=id;
this.from_land = from_land;
this.to_land = to_land;
this.namecompany = namecompany;
this.date = date;
this.no_offirstclass=no_offirstclass;
this.no_ofbusinessclass=no_ofbusinessclass;
this.no_ofeconomyclass=no_ofeconomyclass;
this.firstprice=firstprice;
this.businessprice=businessprice;
this.economyprice=economyprice;
firstclass =new boolean[this.no_offirstclass/4][4];
 businessclass=new boolean [this.no_ofbusinessclass/6][6];
 ecnomyclass=new boolean [this.no_ofeconomyclass/6][6];
}

    public String getId() {
        return Id;
    }

    public String getFrom_land() {
        return from_land;
    }

    public String getTo_land() {
        return to_land;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public String getDate() {
        return date;
    }

    public int getNo_offirstclass() {
        return no_offirstclass;
    }

    public int getNo_ofbusinessclass() {
        return no_ofbusinessclass;
    }

    public int getNo_ofeconomyclass() {
        return no_ofeconomyclass;
    }

    

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setFrom_land(String from_land) {
        this.from_land = from_land;
    }

    public void setTo_land(String to_land) {
        this.to_land = to_land;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNo_offirstclass(int no_offirstclass) {
        this.no_offirstclass = no_offirstclass;
    }

    public void setNo_ofbusinessclass(int no_ofbusinessclass) {
        this.no_ofbusinessclass = no_ofbusinessclass;
    }

    public void setNo_ofeconomyclass(int no_ofeconomyclass) {
        this.no_ofeconomyclass = no_ofeconomyclass;
    }

    public void setFirstprice(double firstprice) {
        this.firstprice = firstprice;
    }

    public void setBusinessprice(double businessprice) {
        this.businessprice = businessprice;
    }

    public void setEconomyprice(double economyprice) {
        this.economyprice = economyprice;
    }

    public double getFirstprice() {
        return firstprice;
    }

    public double getBusinessprice() {
        return businessprice;
    }

    public double getEconomyprice() {
        return economyprice;
    }

    

   
    
}
