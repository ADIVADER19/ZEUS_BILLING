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

 class SHOP
 {
   public static void main(String args[])
   {
    SHOP1 log = new SHOP1();
   }
 }
 public class SHOP1 extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel si,mi,bg;
   ImageIcon img;
   JTextField shopid,masterid;
   JButton login;
   SHOP1()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("SHOP LOGIN");
    c.setVisible(true);  
    c.setSize(700,700);
    c.setLocationRelativeTo(null);
   c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("backlog.png"));
    bg = new JLabel(img);
    c.add(bg);
    
    bg.setLayout(null);
    
    mi = new JLabel("<html><font size ='5' ,color = 'YELLOW'>MASTER-ID : </font></html>");
    mi.setBounds(192,205,150,30);
    bg.add(mi);
    masterid = new JTextField();
    masterid.setBounds(192,255,300,30);
    bg.add(masterid);
   
    si = new JLabel("<html><font size ='5' , color = 'YELLOW'>SHOP-ID : </font></html>");
    si.setBounds(192,305,150,30);
    bg.add(si);
    shopid = new JTextField();
    shopid.setBounds(192,355,300,30);
    bg.add(shopid);
   
    login = new JButton("<html><font size = '5', color = 'YELLOW'>LOGIN</font></html>");
    login.setBounds(292,405,100,70);
    login.setBackground(Color.RED);
    login.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
    bg.add(login);
   
   login.addActionListener(this);
   
}
   public void actionPerformed(ActionEvent ae)
   {
        
                String MasterId = masterid.getText();
                String ShopId = shopid.getText();
                String query = "Select * from shop where master_id=? and shop_id=?";
       if(ShopId.equals("")||MasterId.equals(""))
                {
                  JOptionPane.showMessageDialog(login, "Some Fields Are Empty");
                  shopid.setText("");
                  masterid.setText("");
                }
       else
       {
             try 
                {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "ADVAIT***");
                    PreparedStatement st = connection.prepareStatement(query);
                    st.setString(1, MasterId);
                    st.setString(2, ShopId);
                    ResultSet rs = st.executeQuery();
                  if(rs.next())
                   {
                       dispose();
                       c.setVisible(false);
                       new shopm1().setVisible(true);
      
                   }
                  else
                   {
                     JOptionPane.showMessageDialog(login, "Wrong Master Id Or Shop Id");
                     shopid.setText("");
                     masterid.setText("");
                   }
           
                   
                }
           catch (SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
                
    setVisible(true);
        } 
   }
   
 }
    
