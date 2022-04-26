import java.util.*;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 class feedback
 {
   public static void main()
   {
   feedback1 log = new feedback1();
   }
 }
 class feedback1 extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel u_name,p_name;
   JTextField uname;
   JTextArea comp;
   JButton complaint;
   feedback1()
   {
    c = new JFrame();
    c.setTitle("Complaints Form");
    c.setVisible(true);  
    c.setSize(500,580);
    c.setLocationRelativeTo(null);
    c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    c.setLayout(null);
    
    u_name=new JLabel("<html><font  color='black'>USERNAME</font></html>");
    u_name.setBounds(100,60,150,20);
    c.add(u_name);
    uname = new JTextField();
    uname.setBounds(100,90,250,20);
    c.add(uname);
    
    p_name=new JLabel("<html><font  color='BLACK'>COMPLAINT BOX : </font></html>");
    p_name.setBounds(100,160,350,20);
    c.add(p_name);
    comp = new JTextArea();
    comp.setBounds(100,190,250,250);
    c.add(comp);    
    complaint = new JButton("POST");
    complaint.setBounds(150,490,150,30);
    
complaint.setOpaque(false);
    complaint.setContentAreaFilled(false);
   complaint.setBorder(BorderFactory.createLineBorder(Color.BLACK));
   c.add(complaint);
    complaint.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
   {
     String UserName = uname.getText();
    String Complaint = comp.getText();
    try
    {
     
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String query = "INSERT INTO feedback values('" + UserName + "','" + Complaint + "')";
     Statement sta = connection.createStatement();
     sta.executeUpdate(query);
     JOptionPane.showMessageDialog(complaint,"Complaint Registered");
     connection.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
   }
    
   
 }