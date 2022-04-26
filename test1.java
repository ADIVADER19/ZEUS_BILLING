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

 class test
 {
   public static void main(String args[])
   {
    test1 log = new test1();
   }
 }
 public class test1 extends JFrame 
 {
   JFrame c;
   JLabel si,mi,bg;
   ImageIcon img;
   JTextField shopid,masterid;
   JButton login;
   test1()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("SHOP LOGIN");
    c.setVisible(true);  
    c.setSize(700,700);
    c.setLocationRelativeTo(null);
    c.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("backlog.png"));
    bg = new JLabel(img);
    c.add(bg);
    
    bg.setLayout(null);
    
login = new JButton("<html><font size = '5', color = 'YELLOW'>LOGIN</font></html>");
    login.setBounds(292,405,100,70);
   login.setOpaque(false);
login.setContentAreaFilled(false);
login.setBorderPainted(false);
    bg.add(login);

   
   
   
}
}