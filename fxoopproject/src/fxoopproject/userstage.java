/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxoopproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class userstage {
    User u ;
   // ArrayList <Tickets> f = new ArrayList();
    public GridPane start (BorderPane bp, User u1,adminstrator a1,HBox h1,GridPane logout)
    {
        a1.readfromfile();
        u=u1;
        u.readfromfile();
         HBox h = new HBox();
        h.setPadding(new Insets (15,12,15,12));
        h.setSpacing(10);
        h.setStyle("-fx-background-color: #335699;");
        Image img2;
        try {
            img2 = new Image (new FileInputStream("instabook-logo2.png")); 
            h.getChildren().add(new ImageView ( img2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(userstage.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setTop(h);
        GridPane gp = new GridPane();
        Button b1 = new Button("BOOK TICKETS");
        b1.setPadding(new Insets(15,15,15,15));
        b1.setPrefSize(200, 20);
        b1.setTextFill(Color.web("#FFFFFF"));
        b1.setStyle("-fx-background-color: #335699;");
        Button b2 = new Button("RESERVED TICKETS");
        b2.setPadding(new Insets(15,15,15,15));
        b2.setPrefSize(200, 20);
        b2.setTextFill(Color.web("#FFFFFF"));
        b2.setStyle("-fx-background-color: #335699;");
        Button b3 = new Button("WALLET");
        b3.setPadding(new Insets(15,15,15,15));
        b3.setPrefSize(200, 20);
        b3.setTextFill(Color.web("#FFFFFF"));
        b3.setStyle("-fx-background-color: #335699;");
        b1.setOnAction(e->{
           gp.setVisible(false);
           bp.setCenter(Search(bp,a1,h1,logout));
        });

        b2.setOnAction(e->{
        gp.setVisible(false);
        bp.setCenter(displaytickets(bp,a1,h1,logout));
        });

        b3.setOnAction(e->{
        gp.setVisible(false);
        bp.setCenter(userwallet(bp,a1,h1,logout));

        });
        Button signout = new Button();
        signout .setText("Signout");
        signout.setPrefSize(200, 20);
        signout .setTextFill(Color.web("#FFFFFF"));
        signout .setStyle("-fx-background-color: #335699;");
        signout.setOnAction(e->{
        gp.setVisible(false);
        h1.setVisible(true);
        logout.setVisible(true);
        bp.setTop(h1);
        bp.setCenter(logout);
        });
        gp.add(signout, 0, 4);
       
        gp.add(b1, 0, 1);
        gp.add(b2, 0, 2);
        gp.add(b3, 0, 3);
        gp.setMargin(b1,new Insets(15,15,15, 15));
        gp.setMargin(b2,new Insets(15,15,15, 15));
        gp.setMargin(b3,new Insets(15,15,15, 15));
        gp.setMargin(signout,new Insets(15,15,15, 15));
        gp.setAlignment(Pos.CENTER);
        bp.setCenter(gp);
        return gp;
    }
    public GridPane Search (BorderPane bp,adminstrator a2,HBox h1,GridPane logout)
    {
           GridPane gp = new GridPane();
           Label l = new Label("... SEARCH ...");
           l.setPadding(new Insets(15,15,15,15));
           l.setTextFill(Color.web("#335699"));
           l.setFont(new Font ("arial",30));
           Label l2 = new Label("Take off :");
           l2.setPadding(new Insets(15,15,15,15));
           l2.setTextFill(Color.web("#335699"));
           Label l3 = new Label("Landing :");
           l3.setPadding(new Insets(15,15,15,15));
           l3.setTextFill(Color.web("#335699"));
           TextField ttf = new TextField();
           TextField ltf = new TextField();
           Label l4 = new Label("Seat type :");
           l4.setPadding(new Insets(15,15,15,15));
           l4.setTextFill(Color.web("#335699"));
           final ToggleGroup group = new ToggleGroup(); 
           RadioButton r1 = new RadioButton("firstclass");
           r1.setToggleGroup(group); 
           r1.setSelected(true);
           RadioButton r2 = new RadioButton("businessclass");
           r2.setToggleGroup(group); 
           r2.setSelected(true);
           RadioButton r3 = new RadioButton("economyclass");
           r3.setToggleGroup(group); 
           r3.setSelected(true); 
           Button done = new  Button ("Search");
           done.setPrefSize(100, 15);
           done.setTextFill(Color.web("#FFFFFF"));
           done.setStyle("-fx-background-color: #335699;");
           done.setOnAction((ActionEvent e)->{
              gp.setVisible(false);
              GridPane gp1= new GridPane();
              trip tr =  new  trip ();
              ArrayList<GridPane> arrl = new ArrayList<>();
              ArrayList<Tickets> list1 = new ArrayList<>();
               Button book=new Button() ; 
                 
              if(r1.isSelected())
              { 
                  list1=tr.getticket(a2, ttf.getText(), ltf.getText(), r1.getText());
                  for(int i=0;i<list1.size();i++)
                  {  
                        GridPane g = new GridPane();
                        Label ID =  new Label ();
                        ID.setText("Ticket ID : "+list1.get(i).getId());
                        ID.setPadding(new Insets(15,15,15,15));
                        ID.setTextFill(Color.web("#335699"));
                        Label companyname= new Label ("The company name : "+list1.get(i).getNamecompany());
                        companyname.setPadding(new Insets(15,15,15,15));
                        companyname.setTextFill(Color.web("#335699"));
                        Label takeoff = new Label();
                        takeoff.setText("Take off location : "+list1.get(i).getFrom_land());
                        takeoff.setPadding(new Insets(15,15,15,15));
                        takeoff.setTextFill(Color.web("#335699"));
                        Label landing = new Label();
                        landing.setText("Landing location : "+list1.get(i).getTo_land());
                        landing.setPadding(new Insets(15,15,15,15));
                        landing.setTextFill(Color.web("#335699"));
                        Label date = new Label();
                        date.setText("Date : "+list1.get(i).getDate());
                        date.setPadding(new Insets(15,15,15,15));
                        date.setTextFill(Color.web("#335699"));
                        Label fp = new Label();
                        fp.setText("Pirce of firstclass Seats : "+list1.get(i).getFirstprice());
                        fp.setPadding(new Insets(15,15,15,15));
                        fp.setTextFill(Color.web("#335699"));
                        Label sn = new Label();
                        sn.setText("Seat Number :");
                        sn.setPadding(new Insets(15,15,15,15));
                        sn.setTextFill(Color.web("#335699"));
                        TextField sntf = new TextField ();
                       
                        Tickets t=list1.get(i);
                        book = new Button ("BOOK");
                        book.setPrefSize(100, 15);
                        book .setTextFill(Color.web("#FFFFFF"));
                        book.setStyle("-fx-background-color: #335699;");
                        book.setOnAction((ActionEvent q)->{
                        seats s= new seats();
                       s.pickseat(t, sntf.getText());
                        System.out.println(t.seatname);
                       if(u.Reservation(t))
                       {
                            u.writetofile();
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you have booked this ticket succsefully .");
                               al2.show();
                       }
                       else
                       {
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you do not have enough money in your wallet .");
                               al2.show();
                       }
                        
                        });
                         Button back =  new Button("Back"); 
                  back.setPrefSize(100, 15);
                  back .setTextFill(Color.web("#FFFFFF"));
                  back .setStyle("-fx-background-color: #335699;");
                  back.setOnAction(o->{
                      gp1.setVisible(false);
                     gp.setVisible(false);
                   bp.setCenter(start(bp,u,a2,h1,logout));
        });
                        g.add(ID,0,1);
                        g.add(companyname,0,2);
                        g.add(takeoff, 0, 3);
                        g.add(landing, 0, 4);
                        g.add(date,0,5);
                        g.add(fp, 0, 6);
                        g.add(sn,0,7);
                        g.add(sntf, 1, 7);
                        g.add(book, 0, 8);
                        g.add(back, 1, 8);
                        arrl.add(g);
                       gp1.add(arrl.get(i), 0, i);
                        
                  } 
                  
                 
              }
               else if (r2.isSelected())
               {
                 list1=tr.getticket(a2, ttf.getText(), ltf.getText(), r2.getText());
                  for(int i=0;i<list1.size();i++)
                  {  
                         GridPane g = new GridPane();
                        Label ID =  new Label ();
                        ID.setText("Ticket ID : "+list1.get(i).getId());
                        ID.setPadding(new Insets(15,15,15,15));
                        ID.setTextFill(Color.web("#335699"));
                        Label companyname= new Label ("The company name : "+list1.get(i).getNamecompany());
                        companyname.setPadding(new Insets(15,15,15,15));
                        companyname.setTextFill(Color.web("#335699"));
                        Label takeoff = new Label();
                        takeoff.setText("Take off location : "+list1.get(i).getFrom_land());
                        takeoff.setPadding(new Insets(15,15,15,15));
                        takeoff.setTextFill(Color.web("#335699"));
                        Label landing = new Label();
                        landing.setText("Landing location : "+list1.get(i).getTo_land());
                        landing.setPadding(new Insets(15,15,15,15));
                        landing.setTextFill(Color.web("#335699"));
                        Label date = new Label();
                        date.setText("Date : "+list1.get(i).getDate());
                        date.setPadding(new Insets(15,15,15,15));
                        date.setTextFill(Color.web("#335699"));
                        Label fp = new Label();
                        fp.setText("Pirce of firstclass Seats : "+list1.get(i).getFirstprice());
                        fp.setPadding(new Insets(15,15,15,15));
                        fp.setTextFill(Color.web("#335699"));
                        Label sn = new Label();
                        sn.setText("Seat Number :");
                        sn.setPadding(new Insets(15,15,15,15));
                        sn.setTextFill(Color.web("#335699"));
                        TextField sntf = new TextField ();
                       
                        Tickets t=list1.get(i);
                        book = new Button ("BOOK");
                        book.setPrefSize(100, 15);
                        book .setTextFill(Color.web("#FFFFFF"));
                        book.setStyle("-fx-background-color: #335699;");
                        book.setOnAction((ActionEvent q)->{
                        seats s= new seats();
                       s.pickseat(t, sntf.getText());
                        System.out.println(t.seatname);
                       if(u.Reservation(t))
                       {
                            u.writetofile();
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you have booked this ticket succsefully .");
                               al2.show();
                       }
                       else
                       {
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you do not have enough money in your wallet .");
                               al2.show();
                       }
                        
                        });
                         Button back =  new Button("Back"); 
                  back.setPrefSize(100, 15);
                  back .setTextFill(Color.web("#FFFFFF"));
                  back .setStyle("-fx-background-color: #335699;");
                  back.setOnAction(o->{
                      gp1.setVisible(false);
                     gp.setVisible(false);
                   bp.setCenter(start(bp,u,a2,h1,logout));
        });
                        g.add(ID,0,1);
                        g.add(companyname,0,2);
                        g.add(takeoff, 0, 3);
                        g.add(landing, 0, 4);
                        g.add(date,0,5);
                        g.add(fp, 0, 6);
                        g.add(sn,0,7);
                        g.add(sntf, 1, 7);
                        g.add(book, 0, 8);
                        g.add(back, 1, 8);
                        arrl.add(g);
                       gp1.add(arrl.get(i), 0, i);
                        
                  } 
              }
           else if (r3.isSelected())
            {
                 list1=tr.getticket(a2, ttf.getText(), ltf.getText(), r3.getText());
                  for(int i=0;i<list1.size();i++)
                  {  
                        GridPane g = new GridPane();
                        Label ID =  new Label ();
                        ID.setText("Ticket ID : "+list1.get(i).getId());
                        ID.setPadding(new Insets(15,15,15,15));
                        ID.setTextFill(Color.web("#335699"));
                        Label companyname= new Label ("The company name : "+list1.get(i).getNamecompany());
                        companyname.setPadding(new Insets(15,15,15,15));
                        companyname.setTextFill(Color.web("#335699"));
                        Label takeoff = new Label();
                        takeoff.setText("Take off location : "+list1.get(i).getFrom_land());
                        takeoff.setPadding(new Insets(15,15,15,15));
                        takeoff.setTextFill(Color.web("#335699"));
                        Label landing = new Label();
                        landing.setText("Landing location : "+list1.get(i).getTo_land());
                        landing.setPadding(new Insets(15,15,15,15));
                        landing.setTextFill(Color.web("#335699"));
                        Label date = new Label();
                        date.setText("Date : "+list1.get(i).getDate());
                        date.setPadding(new Insets(15,15,15,15));
                        date.setTextFill(Color.web("#335699"));
                        Label fp = new Label();
                        fp.setText("Pirce of firstclass Seats : "+list1.get(i).getFirstprice());
                        fp.setPadding(new Insets(15,15,15,15));
                        fp.setTextFill(Color.web("#335699"));
                        Label sn = new Label();
                        sn.setText("Seat Number :");
                        sn.setPadding(new Insets(15,15,15,15));
                        sn.setTextFill(Color.web("#335699"));
                        TextField sntf = new TextField ();
                       
                        Tickets t=list1.get(i);
                        book = new Button ("BOOK");
                        book.setPrefSize(100, 15);
                        book .setTextFill(Color.web("#FFFFFF"));
                        book.setStyle("-fx-background-color: #335699;");
                        book.setOnAction((ActionEvent q)->{
                        seats s= new seats();
                       s.pickseat(t, sntf.getText());
                        System.out.println(t.seatname);
                       if(u.Reservation(t))
                       {
                            u.writetofile();
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you have booked this ticket succsefully .");
                               al2.show();
                       }
                       else
                       {
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you do not have enough money in your wallet .");
                               al2.show();
                       }
                        
                        });
                         Button back =  new Button("Back"); 
                  back.setPrefSize(100, 15);
                  back .setTextFill(Color.web("#FFFFFF"));
                  back .setStyle("-fx-background-color: #335699;");
                  back.setOnAction(o->{
                      gp1.setVisible(false);
                     gp.setVisible(false);
                   bp.setCenter(start(bp,u,a2,h1,logout));
        });
                        g.add(ID,0,1);
                        g.add(companyname,0,2);
                        g.add(takeoff, 0, 3);
                        g.add(landing, 0, 4);
                        g.add(date,0,5);
                        g.add(fp, 0, 6);
                        g.add(sn,0,7);
                        g.add(sntf, 1, 7);
                        g.add(book, 0, 8);
                        g.add(back, 1, 8);
                        arrl.add(g);
                       gp1.add(arrl.get(i), 0, i);
                        
                  } 
           }
             
              
               gp1.setAlignment(Pos.CENTER);
              bp.setCenter(gp1);
           });
           Button back =  new Button("Back"); 
           back.setPrefSize(100, 15);
           back .setTextFill(Color.web("#FFFFFF"));
           back .setStyle("-fx-background-color: #335699;");
           back.setOnAction(e->{
               
            gp.setVisible(false);
            bp.setCenter(start(bp,u,a2,h1,logout));
        });
           gp.add(l, 1, 0);
           gp.add(l2, 0, 1); 
           gp.add(l3, 0, 2);
           gp.add(ttf, 1, 1);
           gp.add(ltf, 1, 2);
           gp.add(l4, 0, 3);
           gp.add(r1, 1, 3);
           gp.add(r2,1,4);
           gp.add(r3,1,5);
           gp.add(done,2,6);
           gp.add(back, 0, 6);
           gp.setMargin(r1,new Insets(15,15,15, 15));
           gp.setMargin(r2,new Insets(15,15,15, 15));
           gp.setMargin(r3,new Insets(15,15,15, 15));
           gp.setMargin(done,new Insets(15,15,15, 15));
           gp.setMargin(back,new Insets(15,15,15, 15));
           gp.setAlignment(Pos.CENTER);
           return gp;
    }
    public GridPane displaytickets (BorderPane bp,adminstrator a2,HBox h1,GridPane logout)
    {
        GridPane gp = new GridPane ();
        ArrayList<GridPane> arrl = new ArrayList<>();
        Button cancel=new Button() ; 
//        Tickets t= new Tickets();
                        Label I =  new Label ();
                        I.setText("...Booked Tickets...");
                        I.setPadding(new Insets(15,15,15,15));
                        I.setTextFill(Color.web("#335699")); 
        for(int j=0;j<u.reserved_Tickets.size();j++)
        {

                  
                        GridPane g = new GridPane();
                       Label ID =  new Label ();
                        ID.setText("Ticket ID : "+u.reserved_Tickets.get(j).getId());
                        ID.setPadding(new Insets(15,15,15,15));
                        ID.setTextFill(Color.web("#335699"));
                        Label companyname= new Label ("The company name : "+u.reserved_Tickets.get(j).getNamecompany());
                        companyname.setPadding(new Insets(15,15,15,15));
                        companyname.setTextFill(Color.web("#335699"));
                        Label takeoff = new Label();
                        takeoff.setText("Take off location : "+u.reserved_Tickets.get(j).getFrom_land());
                        takeoff.setPadding(new Insets(15,15,15,15));
                        takeoff.setTextFill(Color.web("#335699"));
                        Label landing = new Label();
                        landing.setText("Landing location : "+u.reserved_Tickets.get(j).getTo_land());
                        landing.setPadding(new Insets(15,15,15,15));
                        landing.setTextFill(Color.web("#335699"));
                        Label date = new Label();
                        date.setText("Date : "+u.reserved_Tickets.get(j).getDate());
                        date.setPadding(new Insets(15,15,15,15));
                        date.setTextFill(Color.web("#335699"));
                        Label fp = new Label();
                        fp.setText("Pirce of firstclass Seats : "+u.reserved_Tickets.get(j).getFirstprice());
                        fp.setPadding(new Insets(15,15,15,15));
                        fp.setTextFill(Color.web("#335699"));
                        Label sn = new Label();
                        sn.setText("Seat Number :"+u.reserved_Tickets.get(j).seatname);
                        sn.setPadding(new Insets(15,15,15,15));
                        sn.setTextFill(Color.web("#335699"));
                       
                       
                        Tickets t=u.reserved_Tickets.get(j);
                        cancel = new Button ("Cancel");
                        cancel.setPrefSize(100, 15);
                        cancel .setTextFill(Color.web("#FFFFFF"));
                        cancel.setStyle("-fx-background-color: #335699;");
                        cancel.setOnAction((ActionEvent q)->{
                        seats s= new seats();
                        s.deleteseat(t);
                       if(u.Cancellation(t))
                       {
                            u.writetofile();
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("you booking have been succsefully canceled .");
                               al2.show();
                       }
                       else
                       {
                            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                           al2.setContentText("there is a problem with your wallet .");
                               al2.show();
                       }
                        
                        });
                         Button back =  new Button("Back"); 
                  back.setPrefSize(100, 15);
                  back .setTextFill(Color.web("#FFFFFF"));
                  back .setStyle("-fx-background-color: #335699;");
                  back.setOnAction(o->{
                     gp.setVisible(false);
                   bp.setCenter(start(bp,u,a2,h1,logout));
        });
                        g.add(ID,0,1);
                        g.add(companyname,0,2);
                        g.add(takeoff, 0, 3);
                        g.add(landing, 0, 4);
                        g.add(date,0,5);
                        g.add(fp, 0, 6);
                        g.add(sn,0,7);
                        
                        g.add(cancel, 0, 8);
                        g.add(back, 1, 8);
                        arrl.add(g);
                       gp.add(arrl.get(j), 0, j);
                       
                  
                  
               
           }      
        gp.add(I, 0, 0);
              gp.setAlignment(Pos.CENTER);
             
           
        return gp;
    }
 public GridPane userwallet (BorderPane bp, adminstrator a2,HBox h1,GridPane logout)
{
  GridPane gp = new GridPane();
  String s =String.valueOf(u.p.getUserwallet());
  Label I =  new Label ();
  I.setFont(new Font ("arial",50));
  I.setText("Wallet Balance : "+s);
  I.setPadding(new Insets(15,15,15,15));
  I.setTextFill(Color.web("#335699")); 
  Label addmoney =  new Label ();
  addmoney.setText("Enter Amount :");
  addmoney.setPadding(new Insets(15,15,15,15));
  addmoney.setTextFill(Color.web("#335699"));
  TextField adtf=new TextField("0.0");
  Button addb =  new Button("Confirm"); 
  addb.setPrefSize(100, 15);
  addb .setTextFill(Color.web("#FFFFFF"));
  addb .setStyle("-fx-background-color: #335699;");
  addb.setOnAction(e->{ 
  double d = Double.parseDouble(adtf.getText());
  u.p.addtowallet(d);
  Alert al2 = new Alert(Alert.AlertType.INFORMATION);
  al2.setContentText("the amount was add to your wallet .");
    al2.show();
    String c =String.valueOf(u.p.getUserwallet());
    I.setText("Wallet Balance : "+c);
  });
   Button back =  new Button("Back"); 
    back.setPrefSize(100, 15);
    back .setTextFill(Color.web("#FFFFFF"));
    back .setStyle("-fx-background-color: #335699;");
    back.setOnAction(o->{
    gp.setVisible(false);
      bp.setCenter(start(bp,u,a2,h1,logout));
        });
    gp.add(addb,1,2);
    gp.add(back, 0, 2);
  gp.add(addmoney,0,1);
  gp.add(adtf, 1, 1);
  gp.add(I, 0, 0);
  gp.setAlignment(Pos.CENTER);
  
  return gp;
}
}

             
              
         
    
    

