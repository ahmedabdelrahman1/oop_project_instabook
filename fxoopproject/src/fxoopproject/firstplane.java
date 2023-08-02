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
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmed Abd El Rahman
 */
public class firstplane {
  BorderPane bp;
  File fil = new File("sign1.txt"); 
   Scene scene;
   HBox h;
   ArrayList<User> acconuts1 =  new ArrayList <>();
   User u1;
   String username;
   String userpassword;
    public firstplane() {
    }
     public void start(Stage primaryStage) throws IOException {
         
        bp=new BorderPane();
         try {
            Image img3 = new Image (new FileInputStream("instabook-logo4.png")); 
             BackgroundImage backgroundimage = new BackgroundImage(img3, 
                                             BackgroundRepeat.NO_REPEAT, 
                                             BackgroundRepeat.NO_REPEAT, 
                                             BackgroundPosition.DEFAULT, 
                                                BackgroundSize.DEFAULT);
            Background b = new Background (backgroundimage);
            bp.setBackground(b);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminstratorstage.class.getName()).log(Level.SEVERE, null, ex);
        }
         h = new HBox();
        h.setPadding(new Insets (15,12,15,12));
        h.setSpacing(10);
        h.setStyle("-fx-background-color: #335699;");
        Image img2 = new Image (new FileInputStream("instabook-logo2.png"));
        Button btsignin = new Button ("Sign in");
        Label l = new Label ();
        btsignin.setPrefSize(100, 20);
        btsignin.setStyle("-fx-background-color: #FFFFFF;");
   
               
        
               
           
        btsignin.setOnAction(e->{signinpane( );
        l.setVisible(false);
        bp.setCenter(signinpane( ));
             readfromfile(fil);
        });
        Button btsignup = new Button ("Sign up");
        btsignup.setPrefSize(100, 20);
        btsignup.setStyle("-fx-background-color: #FFFFFF;");
       Image img = new Image (new FileInputStream("instabook-logo3.png"));
        l.setText(" Welcome to InstaBook ");
        l.setFont(new Font ("Cardo",40));
        bp.setCenter( new ImageView(img) );
      BorderPane bottompane = new BorderPane ();
      l.setTextFill(Color.web("#335699"));
        bp.setBottom(bottompane);
        bottompane.setCenter(l);
        
        h.getChildren().addAll(new ImageView(img2),btsignin,btsignup);
        btsignup.setOnAction(e->{signuppane();
        l.setVisible(false);
        
        bp.setCenter(signuppane());
         readfromfile(fil);
        });
        bp.setTop(h);
        scene = new Scene(bp, 700, 550);
        primaryStage.setTitle("instabook");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public GridPane signinpane (){
        
        GridPane gp = new GridPane();
        Label l  =  new Label ();
        l.setText("Sign In");
        l.setFont(new Font("Arial",40));
        gp.add(l, 1, 0);
        l.setPadding(new Insets(15,15,15,15));
        l.setAlignment(Pos.CENTER);
        Label name =  new Label ();
        name.setText("Username : ");
        name.setPadding(new Insets(15,15,15,15));
        Label password = new Label();
        password.setText("Password : ");
        password.setPadding(new Insets(15,15,15,15));
        gp.add(name,0,4);
        gp.add(password,0,5);
        TextField utf = new TextField();
        gp.add(utf, 1, 4);
        TextField ptf = new TextField();
        gp.add(ptf, 1, 5);
        gp.setAlignment(Pos.CENTER); 
        Button donein =  new Button ("Done");
        donein.setPrefSize(100, 20);
        gp.add(donein, 1, 6);
         donein.setTextFill(Color.web("#FFFFFF"));
        donein.setStyle("-fx-background-color: #335699;");
        donein.setOnAction(e->{try {
            username=utf.getText();
            userpassword=ptf.getText();
            if (check())
            {
                        h.setVisible(false);
                        gp.setVisible(false);
                        
                    userstage u = new userstage();
                    adminstrator a1 = new adminstrator("00001");
                    u.start(bp,u1,a1,h,gp);
            } 
            else if (check()==false)
            {
                if(checkadmin())
                {
                        h.setVisible(false);
                        gp.setVisible(false);
                        
                    adminstratorstage a = new adminstratorstage();
                    a.start(bp,h,gp);
                }
                else 
                {
                    Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("The Username or the Password is wrong.");
                    a.show();
                }
            }
        } catch (FileNotFoundException ex) {
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("The File does not exist .");
                a.show();
        }   
        });
        return gp;
    }
    public GridPane signuppane ()
    {
         GridPane gp = new GridPane();
        Label l  =  new Label ();
        l.setText("Sign UP");
        l.setFont(new Font("Incised",40));
        gp.add(l, 1, 0);
        l.setPadding(new Insets(15,15,15,15));
        l.setAlignment(Pos.CENTER);
        Label name =  new Label ();
        name.setText("Username : ");
        name.setPadding(new Insets(15,15,15,15));
        Label nationality= new Label ("Nationality : ");
        nationality.setPadding(new Insets(15,15,15,15));
        Label password = new Label();
        password.setText("Password : ");
        password.setPadding(new Insets(15,15,15,15));
        Label cpassword = new Label();
        cpassword.setText("confirm Password : ");
        cpassword.setPadding(new Insets(15,15,15,15));
         Label phone_no = new Label();
        phone_no.setText("pohone no : ");
        phone_no.setPadding(new Insets(15,15,15,15));
        Label address = new Label();
        address.setText("address : ");
        address.setPadding(new Insets(15,15,15,15));
        gp.add(name,0,4);
        gp.add(nationality,0,5);
        gp.add(phone_no, 0, 6);
         gp.add(address, 0, 7);
        gp.add(password,0,8);
        gp.add(cpassword, 0, 9);
        TextField utf = new TextField();
        gp.add(utf, 1, 4);
        TextField ntf = new TextField();
        gp.add(ntf, 1, 5);
        TextField pntf = new TextField();
        gp.add(pntf, 1, 6);
        TextField atf = new TextField();
        gp.add(atf, 1, 7);
        TextField ptf = new TextField();
        gp.add(ptf, 1, 8);
         TextField cptf = new TextField();
        gp.add(cptf, 1, 9);
        gp.setAlignment(Pos.CENTER);
        Button doneup =  new Button ("Done");
        doneup.setPrefSize(100, 20);
         doneup.setTextFill(Color.web("#FFFFFF"));
        doneup.setStyle("-fx-background-color: #335699;");
        gp.add(doneup, 1, 10);
        doneup.setOnAction(e->{
                 User a1 =  new User (utf.getText(),ptf.getText(),ntf.getText(),pntf.getText(),atf.getText());
                 if(checkusername(a1))
                 {
                     acconuts1.add(a1);
                     wirtetofile(fil);
                     Alert a = new Alert (AlertType.INFORMATION);
                     a.setContentText("Your account have been created.");
                     a.show();
                     utf.setText("");
                     ntf.setText("");
                     pntf.setText("");
                     atf.setText("");
                     ptf.setText("");
                     cptf.setText("");
                 }
                 else
                 {
                     Alert a = new Alert(AlertType.INFORMATION);
                    a.setContentText("The Username has been used already .");
                    a.show();
                 }
        });
        return gp;    }
    void wirtetofile(File f) 
    {
      try {
          if (!f.exists())
              f.createNewFile();
          if (f.exists())
          {
              FileOutputStream fos = new FileOutputStream(f);
              ObjectOutputStream oos = new ObjectOutputStream (fos);
              oos.writeObject(acconuts1);
              fos.close();
              oos.close();
              
          }
      } catch (IOException ex) {
          Logger.getLogger(firstplane.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
    void readfromfile (File f) 
   {           
       FileInputStream fis ;
   try {
          fis = new FileInputStream (f);
          ObjectInputStream ois = new ObjectInputStream (fis);
          acconuts1=(ArrayList<User>) ois.readObject(); 
          fis.close();
          ois.close();
      } catch (FileNotFoundException | ClassNotFoundException ex) {
           Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("there are some missing files .");
                    a.show();
      } catch (IOException ex) {
          Logger.getLogger(firstplane.class.getName()).log(Level.SEVERE, null, ex);
      }
              
   }
     boolean check ()
   {
       boolean f  = false;
       try{
       for(int i=0 ;i<acconuts1.size();i++)
       {
           if (username.equals(acconuts1.get(i).username)&&userpassword.equals(acconuts1.get(i).userpassword))
           { f=true;
              u1= new User (acconuts1.get(i).username,acconuts1.get(i).userpassword,acconuts1.get(i).nasonaltiy,acconuts1.get(i).phonenumber,acconuts1.get(i).adress);
           }
       }
       }
       catch(IndexOutOfBoundsException e){
           Alert a = new Alert(AlertType.ERROR);
                    a.setContentText("Index out of Bounds  .");
                    a.show();
           
         }
       return f;
       }
      
   boolean checkadmin()
   {
        return "admin".equals(username)&&"admin1234".equals(userpassword);
   }
     boolean checkusername (User a1) 
    {
       for(int i=0;i<acconuts1.size();i++)
       {
           if(a1.username.equals(acconuts1.get(i).username))
           {
               return false;
           }
       }
       return true;
    }
}

