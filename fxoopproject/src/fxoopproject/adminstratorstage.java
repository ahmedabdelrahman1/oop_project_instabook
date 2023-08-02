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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class adminstratorstage {
    adminstrator a;
    File f = new File("signID.data");
    ArrayList <adminstrator> admin = new ArrayList <> ();
    String aID;
    public adminstratorstage() {
    }
    
    public void start (BorderPane bp,HBox h1,GridPane logout) throws FileNotFoundException
    {
        
        HBox h = new HBox();
        h.setPadding(new Insets (15,12,15,12));
        h.setSpacing(10);
        h.setStyle("-fx-background-color: #335699;");
        Image img2 = new Image (new FileInputStream("instabook-logo2.png"));
        h.getChildren().add(new ImageView ( img2));
        GridPane gp= new GridPane ();
        Label l= new Label();
        l.setText("Enter ID");
        l.setFont(new Font ("arial",30));
        l.setTextFill(Color.web("#335699"));
        l.setPadding(new Insets(15,15,15,15));
        gp.add(l, 1, 0);
        Label ID = new Label();
        ID.setText("ID : ");
        ID.setTextFill(Color.web("#335699"));
        ID.setFont(new Font ("arial",25));
        gp.add(ID, 0, 2);
        TextField IDtf= new TextField();
        gp.add(IDtf, 1, 2);
        ID.setPadding(new Insets(15,15,15,15));
        IDtf.setPadding(new Insets(15,15,15,15));
        Button checkid= new Button();
        checkid.setText("Done");
        checkid.setPadding(new Insets(15,15,15,15));
        checkid.setPrefSize(100, 20);
        checkid.setTextFill(Color.web("#FFFFFF"));
        checkid.setStyle("-fx-background-color: #335699;");
        checkid.setOnAction(e->{
             
             aID=IDtf.getText();
             
             if(checkmanager())
             {
                 a = new adminstrator(IDtf.getText());
                 a.readfromfile();
                 readfromfile(f);
                 gp.setVisible(false);
                 bp.setCenter(Manager(bp,h1,logout));
                 
             }
             else{
                 
                 readfromfile(f);
                 if(checkadmin())
                 {
                     a = new adminstrator(IDtf.getText());
                     a.readfromfile();
                     gp.setVisible(false);
                     bp.setCenter(normaladmin(bp,h,logout));
                 }
                 else
                 {
                     Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                     al2.setContentText("please check that you id is croccect .");
                     al2.show();
                 }
             }
        });
        gp.add(checkid,1,3);
        gp.setAlignment(Pos.CENTER);
        bp.setCenter(gp);
        bp.setTop(h);
         
       
    }
    public GridPane Manager (BorderPane bp,HBox h,GridPane logout)
    {
        GridPane gp =  new GridPane ();
        Button add = new Button();
        add.setText("Add an admin");
        add.setPrefSize(200, 15);
        add.setTextFill(Color.web("#FFFFFF"));
        add.setStyle("-fx-background-color: #335699;");
        add.setOnAction(e->{
            readfromfile(f);
            gp.setVisible(false);
            GridPane gp1= new GridPane();
            Label Id = new Label("ID:");
            Id.setTextFill(Color.web("#335699"));
            gp1.add(Id, 0, 0);
            TextField Idtf =  new TextField ();
            Button doneid = new Button ("Done");
            doneid.setPrefSize(200, 15);
            doneid.setTextFill(Color.web("#FFFFFF"));
            doneid.setStyle("-fx-background-color: #335699;");
            doneid.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    adminstrator a1 = new adminstrator (Idtf.getText());
                    createadmin(a1);
                    wirtetofile(f);
                    gp1.setVisible(false);
                    gp.setVisible(true);
                    bp.setCenter(gp);
                }
            });
            gp1.add(Idtf,1,0);
            gp1.add(doneid, 1, 2);
            gp1.setAlignment(Pos.CENTER);
            bp.setCenter(gp1);
            
        });
        Button createticket = new Button();
        createticket.setText("Create Ticket");
        createticket.setPrefSize(200, 15);
        createticket.setTextFill(Color.web("#FFFFFF"));
        createticket.setStyle("-fx-background-color: #335699;");
        createticket.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(CreateTicket(bp,h,logout));
        });
        Button Display = new Button();
        Display .setText("Display Ticket");
        Display.setPrefSize(200, 15);
        Display .setTextFill(Color.web("#FFFFFF"));
        Display .setStyle("-fx-background-color: #335699;");
         Display.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(DisplayTickets(bp,h,logout));
        });
        Button edit = new Button();
        edit .setText("Edit a Tickect");
        edit.setPrefSize(200, 15);
        edit .setTextFill(Color.web("#FFFFFF"));
        edit .setStyle("-fx-background-color: #335699;");
        edit.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(EditTickets(bp,h,logout));
        });
        Button signout = new Button();
        signout .setText("Signout");
        signout.setPrefSize(200, 15);
        signout .setTextFill(Color.web("#FFFFFF"));
        signout .setStyle("-fx-background-color: #335699;");
        signout.setOnAction(e->{
        gp.setVisible(false);
        h.setVisible(true);
        logout.setVisible(true);
        bp.setTop(h);
        bp.setCenter(logout);
        });
        gp.add(signout, 0, 4);
        gp.add(add, 0, 0);
        gp.add(createticket, 1, 1);
        gp.add(Display, 0, 2);
        gp.add(edit, 1, 3);
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(15,15,15, 15));
        gp.setMargin(add,new Insets(15,15,15, 15));
        gp.setMargin(createticket,new Insets(15,15,15, 15));
        gp.setMargin(Display,new Insets(15,15,15, 15));
        gp.setMargin(edit,new Insets(15,15,15, 15));
        return gp;
    }
    public GridPane normaladmin (BorderPane bp,HBox h,GridPane logout)
    {
        GridPane gp = new GridPane();
         Button createticket = new Button();
        createticket.setText("Create Ticket");
        createticket.setPrefSize(200, 15);
        createticket.setTextFill(Color.web("#FFFFFF"));
        createticket.setStyle("-fx-background-color: #335699;");
        createticket.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(CreateTicket(bp,h,logout));
        });
        Button Display = new Button();
        Display .setText("Display Ticket");
        Display.setPrefSize(200, 15);
        Display .setTextFill(Color.web("#FFFFFF"));
        Display .setStyle("-fx-background-color: #335699;");
        Display.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(DisplayTickets(bp,h,logout));
        });
        Button edit = new Button();
        edit .setText("Edit a Tickect");
        edit.setPrefSize(200, 15);
        edit .setTextFill(Color.web("#FFFFFF"));
        edit .setStyle("-fx-background-color: #335699;");
        edit.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(EditTickets(bp,h,logout));
        });
        Button signout = new Button();
        signout .setText("Signout");
        signout.setPrefSize(200, 15);
        signout .setTextFill(Color.web("#FFFFFF"));
        signout .setStyle("-fx-background-color: #335699;");
        signout.setOnAction(e->{
        gp.setVisible(false);
        h.setVisible(true);
        logout.setVisible(true);
        bp.setTop(h);
        bp.setCenter(logout);
        });
        gp.add(signout, 0, 4);
        gp.add(createticket, 1, 1);
        gp.add(Display, 0, 2);
        gp.add(edit, 1, 3);
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(15,15,15, 15));
        gp.setMargin(createticket,new Insets(15,15,15, 15));
        gp.setMargin(Display,new Insets(15,15,15, 15));
        gp.setMargin(edit,new Insets(15,15,15, 15));
        return gp;
    }
    public GridPane CreateTicket ( BorderPane bp,HBox h,GridPane logout)
    {
        GridPane gp = new GridPane ();
        Label l  =  new Label ();
        l.setText("Create Ticket");
        l.setFont(new Font("Incised",40));
        l.setTextFill(Color.web("#335699"));
        gp.add(l, 1, 0);
        l.setPadding(new Insets(15,15,15,15));
        Label ID =  new Label ();
        ID.setText("Ticket ID : ");
        ID.setPadding(new Insets(15,15,15,15));
        ID.setTextFill(Color.web("#335699"));
        Label companyname= new Label ("The company name : ");
        companyname.setPadding(new Insets(15,15,15,15));
        companyname.setTextFill(Color.web("#335699"));
        Label takeoff = new Label();
        takeoff.setText("Take off location : ");
        takeoff.setPadding(new Insets(15,15,15,15));
        takeoff.setTextFill(Color.web("#335699"));
        Label landing = new Label();
        landing.setText("Landing location : ");
        landing.setPadding(new Insets(15,15,15,15));
        landing.setTextFill(Color.web("#335699"));
         Label date = new Label();
        date.setText("Date : ");
        date.setPadding(new Insets(15,15,15,15));
        date.setTextFill(Color.web("#335699"));
        Label onf = new Label();
        onf.setText("No of firstclass Seats : ");
        onf.setPadding(new Insets(15,15,15,15));
        onf.setTextFill(Color.web("#335699"));
        Label fp = new Label();
        fp.setText("Pirce of firstclass Seats : ");
        fp.setPadding(new Insets(15,15,15,15));
        fp.setTextFill(Color.web("#335699"));
        Label onb = new Label();
        onb.setText("No of businessclass Seats : ");
        onb.setPadding(new Insets(15,15,15,15));
        onb.setTextFill(Color.web("#335699"));
        Label bcp = new Label();
        bcp.setText("Pirce of businessclass Seats : ");
        bcp.setPadding(new Insets(15,15,15,15));
        bcp.setTextFill(Color.web("#335699"));
        Label one = new Label();
        one.setText("No of economyclass Seats : ");
        one.setPadding(new Insets(15,15,15,15));
        one.setTextFill(Color.web("#335699"));
        Label ep = new Label();
        ep.setText("Pirce of economyclass Seats : ");
        ep.setPadding(new Insets(15,15,15,15));
        ep.setTextFill(Color.web("#335699"));
        gp.add(ID,0,4);
        gp.add(companyname,0,5);
        gp.add(takeoff, 0, 6);
         gp.add(landing, 0, 7);
        gp.add(date,0,8);
        gp.add(onf, 0, 9);
        gp.add(fp, 0, 10);
        gp.add(onb, 0, 11);
        gp.add(bcp, 0, 12);
        gp.add(one, 0, 13);
        gp.add(ep, 0, 14);
        TextField itf = new TextField();
        gp.add(itf, 1, 4);
        TextField ctf = new TextField();
        gp.add(ctf, 1, 5);
        TextField ttf = new TextField();
        gp.add(ttf, 1, 6);
        TextField ltf = new TextField();
        gp.add(ltf, 1, 7);
        TextField dtf = new TextField();
        gp.add(dtf, 1, 8);
         TextField onftf = new TextField();
        gp.add(onftf, 1, 9);
        TextField fptf = new TextField();
        gp.add(fptf, 1, 10);
        TextField onbtf = new TextField();
        gp.add(onbtf, 1, 11);
        TextField bcptf = new TextField();
        gp.add(bcptf, 1, 12);
        TextField onetf = new TextField();
        gp.add(onetf, 1, 13);
        TextField eptf = new TextField();
        gp.add(eptf, 1, 14);
        Button back =  new Button("Back"); 
        back.setPrefSize(200, 15);
        back .setTextFill(Color.web("#FFFFFF"));
        back .setStyle("-fx-background-color: #335699;");
        Button confirm =  new Button("Confirm"); 
        confirm.setPrefSize(200, 15);
        confirm .setTextFill(Color.web("#FFFFFF"));
        confirm .setStyle("-fx-background-color: #335699;");
        gp.add(back, 0, 15);
        gp.add(confirm, 1, 15);
        back.setOnAction(e->{
            gp.setVisible(false);
            bp.setCenter(Manager(bp,h,logout));
        });
        confirm.setOnAction(e->{
             int i,j,k;
            double p,o,u;
            i=Integer.parseInt(onftf.getText());
            j=Integer.parseInt(onbtf.getText()); 
            k=Integer.parseInt(onetf.getText()); 
            p=Double.parseDouble(fptf.getText()); 
            o=Double.parseDouble(bcptf.getText()); 
            u=Double.parseDouble(eptf.getText()); 
           Tickets t1= new Tickets (itf.getText(),ttf.getText(),ltf.getText(),ctf.getText(),dtf.getText(),i,j,k,p,o,u);
        a.create(t1);
        a.writetofile();
        Alert a3 = new Alert(Alert.AlertType.INFORMATION);
                    a3.setContentText("the ticket have been created .");
                    a3.show();
        });
        gp.setAlignment(Pos.CENTER);
        
        return gp;
    }
    public GridPane DisplayTickets (BorderPane bp,HBox h,GridPane logout)
    {
        GridPane gp =new GridPane();
        Label Id = new Label("Ticket ID:");
       Id.setFont(new Font ("arial",25));
        Id.setTextFill(Color.web("#335699"));
        gp.add(Id, 0, 0);
       TextField Idtf =  new TextField ();
        Button doneid = new Button ("Sreach");
       doneid.setPrefSize(200, 15);
       doneid.setTextFill(Color.web("#FFFFFF"));
       doneid.setStyle("-fx-background-color: #335699;");
       gp.add(Idtf, 1, 0);
        gp.add(doneid, 0, 1);
       gp.setAlignment(Pos.CENTER);
        doneid.setOnAction(e->{
                gp.setVisible(false);
                
                GridPane gp1= new GridPane();
                bp.setCenter(gp1);
            Tickets t1;
            t1=a.sreach(Idtf.getText());
            System.out.println(t1.getId());
            Label l  =  new Label ();
            l.setText("Display Ticket");
            l.setFont(new Font("Incised",40));
            l.setTextFill(Color.web("#335699"));
            gp1.add(l, 0, 0);
            l.setPadding(new Insets(15,15,15,15));
            Label ID =  new Label ();
            ID.setText("Ticket ID : "+t1.getId());
            ID.setPadding(new Insets(15,15,15,15));
            ID.setTextFill(Color.web("#335699"));
            Label companyname= new Label ("The company name : "+t1.getNamecompany());
            companyname.setPadding(new Insets(15,15,15,15));
            companyname.setTextFill(Color.web("#335699"));
            Label takeoff = new Label();
            takeoff.setText("Take off location : "+t1.getFrom_land());
            takeoff.setPadding(new Insets(15,15,15,15));
            takeoff.setTextFill(Color.web("#335699"));
            Label landing = new Label();
            landing.setText("Landing location : "+t1.getTo_land());
            landing.setPadding(new Insets(15,15,15,15));
            landing.setTextFill(Color.web("#335699"));
            Label date = new Label();
            date.setText("Date : "+t1.getDate());
            date.setPadding(new Insets(15,15,15,15));
            date.setTextFill(Color.web("#335699"));
            Label onf = new Label();
            onf.setText("No of firstclass Seats : "+t1.getNo_offirstclass());
            onf.setPadding(new Insets(15,15,15,15));
            onf.setTextFill(Color.web("#335699"));
            Label fp = new Label();
            fp.setText("Pirce of firstclass Seats : "+t1.getFirstprice());
            fp.setPadding(new Insets(15,15,15,15));
            fp.setTextFill(Color.web("#335699"));
            Label onb = new Label();
            onb.setText("No of businessclass Seats : "+t1.getNo_ofbusinessclass());
            onb.setPadding(new Insets(15,15,15,15));
            onb.setTextFill(Color.web("#335699"));
            Label bcp = new Label();
            bcp.setText("Pirce of businessclass Seats : "+t1.getBusinessprice());
            bcp.setPadding(new Insets(15,15,15,15));
            bcp.setTextFill(Color.web("#335699"));
            Label one = new Label();
            one.setText("No of economyclass Seats : "+t1.getNo_ofeconomyclass());
            one.setPadding(new Insets(15,15,15,15));
            one.setTextFill(Color.web("#335699"));
            Label ep = new Label();
            ep.setText("Pirce of economyclass Seats : "+t1.getEconomyprice());
            ep.setPadding(new Insets(15,15,15,15));
            ep.setTextFill(Color.web("#335699"));
            gp1.add(ID,0,4);
            gp1.add(companyname,0,5);
            gp1.add(takeoff, 0, 6);
            gp1.add(landing, 0, 7);
            gp1.add(date,0,8);
            gp1.add(onf, 0, 9);
            gp1.add(fp, 0, 10);
            gp1.add(onb, 0, 11);
            gp1.add(bcp, 0, 12);
            gp1.add(one, 0, 13);
            gp1.add(ep, 0, 14);
            Button back =  new Button("Back"); 
        back.setPrefSize(200, 15);
        back .setTextFill(Color.web("#FFFFFF"));
        back .setStyle("-fx-background-color: #335699;");
        gp1.add(back, 1, 15);
        gp1.setAlignment(Pos.CENTER);
        back.setOnAction(o->{
            gp1.setVisible(false);
            bp.setCenter(Manager(bp,h,logout));
        });
            });
        return gp;
    }
    public GridPane EditTickets (BorderPane bp,HBox h,GridPane logout)
    {
        GridPane gp=new GridPane();
        Label Id = new Label("Ticket ID:");
       Id.setFont(new Font ("arial",25));
        Id.setTextFill(Color.web("#335699"));
        gp.add(Id, 0, 0);
       TextField Idtf =  new TextField ();
        Button doneid = new Button ("Sreach");
       doneid.setPrefSize(200, 15);
       doneid.setTextFill(Color.web("#FFFFFF"));
       doneid.setStyle("-fx-background-color: #335699;");
       gp.add(Idtf, 1, 0);
        gp.add(doneid, 0, 1);
       gp.setAlignment(Pos.CENTER);
        doneid.setOnAction(e->{
            Tickets t1;
            t1=a.sreach(Idtf.getText());
            gp.setVisible(false);
            GridPane gp1=new GridPane();
            bp.setCenter(gp1);
           Label l  =  new Label ();
            l.setText("Edit Ticket");
            l.setFont(new Font("Incised",40));
            l.setTextFill(Color.web("#335699"));
            gp1.add(l, 1, 0);
            l.setPadding(new Insets(15,15,15,15));
            Label ID =  new Label ();
            ID.setText("Ticket ID : ");
            ID.setPadding(new Insets(15,15,15,15));
            ID.setTextFill(Color.web("#335699"));
            Label companyname= new Label ("The company name : ");
            companyname.setPadding(new Insets(15,15,15,15));
            companyname.setTextFill(Color.web("#335699"));
            Label takeoff = new Label();
            takeoff.setText("Take off location : ");
            takeoff.setPadding(new Insets(15,15,15,15));
            takeoff.setTextFill(Color.web("#335699"));
            Label landing = new Label();
            landing.setText("Landing location : ");
            landing.setPadding(new Insets(15,15,15,15));
            landing.setTextFill(Color.web("#335699"));
            Label date = new Label();
            date.setText("Date : ");
            date.setPadding(new Insets(15,15,15,15));
            date.setTextFill(Color.web("#335699"));
            Label onf = new Label();
            onf.setText("No of firstclass Seats : ");
            onf.setPadding(new Insets(15,15,15,15));
            onf.setTextFill(Color.web("#335699"));
            Label fp = new Label();
            fp.setText("Pirce of firstclass Seats : ");
            fp.setPadding(new Insets(15,15,15,15));
            fp.setTextFill(Color.web("#335699"));
            Label onb = new Label();
            onb.setText("No of businessclass Seats : ");
            onb.setPadding(new Insets(15,15,15,15));
            onb.setTextFill(Color.web("#335699"));
            Label bcp = new Label();
            bcp.setText("Pirce of businessclass Seats : ");
            bcp.setPadding(new Insets(15,15,15,15));
            bcp.setTextFill(Color.web("#335699"));
            Label one = new Label();
            one.setText("No of economyclass Seats : ");
            one.setPadding(new Insets(15,15,15,15));
            one.setTextFill(Color.web("#335699"));
            Label ep = new Label();
            ep.setText("Pirce of economyclass Seats : ");
            ep.setPadding(new Insets(15,15,15,15));
            ep.setTextFill(Color.web("#335699"));
            gp1.add(ID,0,4);
            gp1.add(companyname,0,5);
            gp1.add(takeoff, 0, 6);
            gp1.add(landing, 0, 7);
            gp1.add(date,0,8);
            gp1.add(onf, 0, 9);
            gp1.add(fp, 0, 10);
            gp1.add(onb, 0, 11);
            gp1.add(bcp, 0, 12);
            gp1.add(one, 0, 13);
            gp1.add(ep, 0, 14);
            TextField itf = new TextField();
            itf.setText(t1.getId());
            gp1.add(itf, 1, 4);
            TextField ctf = new TextField();
            ctf.setText(t1.getNamecompany());
            gp1.add(ctf, 1, 5);
            TextField ttf = new TextField();
            ttf.setText(t1.getFrom_land());
            gp1.add(ttf, 1, 6);
            TextField ltf = new TextField();
            ltf.setText(t1.getTo_land());
            gp1.add(ltf, 1, 7);
            TextField dtf = new TextField();
            dtf.setText(t1.getDate());
            gp1.add(dtf, 1, 8);
            TextField onftf = new TextField();
            onftf.setText(String.valueOf(t1.getNo_offirstclass()));
            gp1.add(onftf, 1, 9);
            TextField fptf = new TextField();
            fptf.setText(String.valueOf(t1.getFirstprice()));
            gp1.add(fptf, 1, 10);
            TextField onbtf = new TextField();
            onbtf.setText(String.valueOf(t1.getNo_ofbusinessclass()));
            gp1.add(onbtf, 1, 11);
            TextField bcptf = new TextField();
            bcptf.setText(String.valueOf(t1.getBusinessprice()));
            gp1.add(bcptf, 1, 12);
            TextField onetf = new TextField();
            onetf.setText(String.valueOf(t1.getNo_ofeconomyclass()));
            gp1.add(onetf, 1, 13);
            TextField eptf = new TextField();
            eptf.setText(String.valueOf(t1.getEconomyprice()));
            gp1.add(eptf, 1, 14);
            Button confirm =  new Button("Save"); 
            confirm.setPrefSize(200, 15);
            confirm .setTextFill(Color.web("#FFFFFF"));
            confirm .setStyle("-fx-background-color: #335699;");
            gp1.add(confirm, 1, 15);
            gp1.setAlignment(Pos.CENTER);
          confirm.setOnAction(z->{
            int i,j,k;
            double p,o,u;
            i=Integer.parseInt(onftf.getText());
            j=Integer.parseInt(onbtf.getText()); 
            k=Integer.parseInt(onetf.getText()); 
            p=Double.parseDouble(fptf.getText()); 
            o=Double.parseDouble(bcptf.getText()); 
            u=Double.parseDouble(eptf.getText()); 
            Tickets t2= new Tickets (itf.getText(),ttf.getText(),ltf.getText(),ctf.getText(),dtf.getText(),i,j,k,p,o,u);
            a.edit(t2, a.getindex(t1));
            a.writetofile(); 
            Alert a3 = new Alert(Alert.AlertType.INFORMATION);
                    a3.setContentText("the ticket have been edited .");
                    a3.show();
            gp1.setVisible(false);
            bp.setCenter(Manager(bp,h,logout));
           
           });
        });
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    public void createadmin (adminstrator a) {
        admin.add(a);   
    }
    public boolean checkmanager ()
    {
        return "00001".equals(aID);
    }
    public boolean checkadmin () 
    {
        try{
        for(int i=0 ;i<admin.size();i++)
        {
           
            if(aID.equals(admin.get(i).getAdminstorid())) {
            } else { 
                return true;
            } 
        }
        }
        catch(IndexOutOfBoundsException e){
        Alert a3 = new Alert(Alert.AlertType.ERROR);
                    a3.setContentText("Index out of bounds .");
                    a3.show();
        }
        return false;
    }
    void wirtetofile(File f) 
    {
        if (!f.exists())
            try {
                f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(adminstratorstage.class.getName()).log(Level.SEVERE, null, ex);
        }
        else 
        { 
               FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream (fos);
                oos.writeObject(admin);
                oos.close();
            } catch (FileNotFoundException ex) {
                Alert a3 = new Alert(Alert.AlertType.ERROR);
                    a3.setContentText("file is not found  .");
                    a3.show();
            } catch (IOException ex) {
                Logger.getLogger(adminstratorstage.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } 
    }
    void readfromfile (File f) 
   {
                
                FileInputStream fis =null;
        try {
            fis = new FileInputStream (f);
            ObjectInputStream ois = new ObjectInputStream (fis);
            admin=(ArrayList<adminstrator>) ois.readObject(); 
            fis.close();
        } catch (FileNotFoundException ex) {
           Alert a3 = new Alert(Alert.AlertType.ERROR);
                    a3.setContentText("file is not found  .");
                    a3.show();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(adminstratorstage.class.getName()).log(Level.SEVERE, null, ex);
        } 
              
   }
   
}
