
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
 class LoginFor
 {
   public static void main()
   {
    LoginForm log = new LoginForm();
   }
 }
 public class LoginForm extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel u_name,p_name,passign,bg;
   ImageIcon img;
   JTextField uname;
   JPasswordField pname;
   JComboBox post;
   JButton login,reset;
   LoginForm()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("Login Form");
    c.setVisible(true);  
    c.setSize(500,500);
    c.setLocationRelativeTo(null);
     c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("log.jpg"));
    bg = new JLabel(img);
    c.add(bg);
    bg.setLayout(null);
    
    u_name=new JLabel("<html><font  color='white'>USERNAME</font></html>");
    u_name.setBounds(150,60,100,20);
    bg.add(u_name);
    uname = new JTextField();
    uname.setBounds(150,90,200,20);
    bg.add(uname);
   p_name=new JLabel("<html><font  color='white'>PASSWORD</font></html>");
   
    p_name.setBounds(150,160,100,20);
    
    bg.add(p_name);
    pname = new JPasswordField();
    pname.setBounds(150,190,200,20);
    bg.add(pname);
   
    passign = new JLabel("<html><font  color='white'>POST ASSIGN</font></html>");
   
    passign.setBounds(150,260,200,20);
    bg.add(passign);
   
    String posts[]={"Select","StockChecker","BillManager"};
    post = new JComboBox(posts);
    post.setBounds(150,290,210,20);
    bg.add(post);
   
    login = new JButton("LOGIN");
    login.setBounds(150,360,80,30);
    bg.add(login);
   
    reset = new JButton("RESET");
    reset.setBounds(240,360,80,30);
    bg.add(reset);
    login.addActionListener(this);
    reset.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
   {
     if(ae.getSource()==login)
     {
   
                String UserName = uname.getText();
                String Password = pname.getText();
                String Job = post.getSelectedItem()+"";
                String query = "Select * from workers where UserName=? and Password=?";
                if(UserName.equals("")||Password.equals("")||Job.equals("Select"))
                {
                  JOptionPane.showMessageDialog(login, "Some Fields Are Empty");
                }
                else
                {
                try
                {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject",
                        "root", "ADVAIT***");
                    PreparedStatement st = connection.prepareStatement(query);
                    st.setString(1, UserName);
                    st.setString
                    (2, Password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next())
                    {
                        dispose();
                       
                       JOptionPane.showMessageDialog(login, "You have successfully logged in");
                       if(Job.equalsIgnoreCase("StockChecker"))
                       {
                           
                         sc st1 = new sc();
                         st1.setVisible(true);
                         setVisible(false);
                       }
                       if(Job.equalsIgnoreCase("BillManager"))
                       {
                         billf1 bm = new billf1();
                         bm.setVisible(true);
                         setVisible(false);
                       }
                      
                    } 
                    else
                    {
                        JOptionPane.showMessageDialog(login, "Wrong Username & Password");
                    }
           
                }
               catch(SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
                }
      }
      else
      {
         uname.setText("");
         pname.setText("");
         post.setSelectedIndex(0);
      }
 
    }
    
   
 }
    