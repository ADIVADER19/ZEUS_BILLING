import java.util.*;
import java.util.Scanner;
import java.sql.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import javax.swing.JTable;



 public class DemoJdbc
 {
   public static void main ()throws Exception
   {
     Scanner sc = new Scanner(System.in);
     String ITEMNAME;
     int Q;
     System.out.println("Enter Item Name");
     ITEMNAME = sc.nextLine();
     System.out.println("Enter Quantity");
     Q = sc.nextInt();
     String url = "jdbc:mysql://localhost:3306/javaproject";
     String username = "root";
     String password = "ADVAIT***";
     String query = "SELECT QUANTITY FROM item where ITEM_NAME=?";
     Connection con = DriverManager.getConnection(url,username,password);
     PreparedStatement pst = con.prepareStatement(query);
     pst.setString(1,ITEMNAME);
     ResultSet rs = pst.executeQuery();
     int data = 0;
     while(rs.next())
     {
       data = rs.getInt("QUANTITY");
     }
     System.out.println("Quantity that is inserted by stock checker in database");
     System.out.println(data);
     int d = data-Q;
     if(d<0)
     {
       System.out.print("You have only ");
       System.out.print(data);
       System.out.println("In stock");
     }
     else if(d==0)
     {
       System.out.println("Out of stock");
     }
     else
     {
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String q = "Update item set QUANTITY=? where ITEM_NAME=?";
     pst = con.prepareStatement(q);
     pst.setInt(1,d);
     pst.setString(2,ITEMNAME);
     pst.executeUpdate();
       System.out.println("Trial Successfull");
     }
    
     pst.close();
     con.close();
   }
}