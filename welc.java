import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
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
import java.util.Vector;

 public class welc
 {
   public static void main()
   {
       welcome1 obj=new welcome1();
   }
 }
 class welcome1 extends JFrame implements ActionListener
 {
   JButton login,signup,home,about,complain;
   JLabel or,cont,bg;
   JFrame f;
   ImageIcon img;
   welcome1()
   {
     f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setTitle("ZEUS BILLING");
    f.setVisible(true);  
    f.setSize(1280,777);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("ah.png"));
    bg = new JLabel(img);
    f.add(bg);
    bg.setLayout(null);
     home = new JButton("<html><font size = '5',color = 'white'>HOME</font></html>");
     
     home.setBounds(0,28,100,70);
     home.setOpaque(false);
     home.setContentAreaFilled(false);
     home.setBorderPainted(false);
     bg.add(home);
     home.addActionListener(this);
     about = new JButton("<html><font size = '5',color = 'white'>ABOUT US</font></html>");
     
     about.setBounds(100,28,150,70);
     about.setOpaque(false);
     about.setContentAreaFilled(false);
     about.setBorderPainted(false);
     bg.add(about);
     about.addActionListener(this);
     complain = new JButton("<html><font size = '5',color = 'white'>COMPLAINTS</font></html>");
       
     complain.setBounds(250,28,257,70);
     complain.setOpaque(false);
     complain.setContentAreaFilled(false);
     complain.setBorderPainted(false);
     bg.add(complain);
     complain.addActionListener(this);
  
     
     login = new JButton("<html><font size = '7',color = 'white'>LOGIN</font></html>");
     
     login.setBounds(448,340,200,70);
     login.setOpaque(false);
     login.setContentAreaFilled(false);
     login.setBorder(BorderFactory.createLineBorder(Color.WHITE));
     bg.add(login);
     login.addActionListener(this);
     
     
     or = new JLabel("<html><font size = '7',color = 'white'>OR</font></html>");
     or.setBounds(673,340,50,70);
     bg.add(or);
     
     signup = new JButton("<html><font size = '7',color = 'white'>SIGN UP</font></html>");
    
     signup.setBounds(748,340,200,70);
     signup.setOpaque(false);
     signup.setContentAreaFilled(false);
     signup.setBorder(BorderFactory.createLineBorder(Color.WHITE));
     bg.add(signup);
      signup.addActionListener(this);
    
      
     cont = new JLabel("<html><font size = '7',color = 'white'>TO CONTINUE</font></html>");
     cont.setBounds(523,430,350,70);
     bg.add(cont);
     
    
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==home)
      {
        
        
      }
      if(e.getSource()==about)
      {
          about1 s1 = new about1();
                         s1.setVisible(true);
                         setVisible(true);
        
      }
       if(e.getSource()==complain)
      {
          feedback1 s1 = new feedback1();
                         s1.setVisible(true);
                         setVisible(true);
        
        
      }
   
      if(e.getSource()==login)
      {
           SHOP1 s1 = new SHOP1();
                         s1.setVisible(true);
                         setVisible(false);
        
      }
      if(e.getSource()==signup)
      {
           shopreg s1 = new shopreg();
                         s1.setVisible(true);
                         setVisible(false);
        
      }
    }
}