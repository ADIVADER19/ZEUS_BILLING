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
  
  
class item1 extends JFrame  implements ActionListener
{
    static int ftotal=0,fcart=0;
    int price1,total,quantity;
    JFrame i;
    JTextField q,p,it;
    JLabel l,l1,tot,car,ftot,fcar;
    JButton totall,cart,proceed,back;
    
       public static void main(String[] args)
    {
       
 
   item1 obj=new item1();
 
}
    item1()
    {
     
       
         ImageIcon icon= new ImageIcon("dinho.jpg");
        setLayout(new GridLayout(12,1));
        
        
        pack();
        JLabel i=new JLabel("ITEM NAME:");
        add(i);
        it=new JTextField();
        add(it);
        JLabel p1=new JLabel("PRICE:");
         add(p1);
        p=new JTextField();
        add(p);
        
        JLabel q1=new JLabel("QUANTITY");
        add(q1);
        q=new JTextField();
        
        add(q);
        
        setVisible(true);
        proceed=new JButton("PROCEED");
          
        proceed.addActionListener(this);
        
        add(proceed);
        tot=new JLabel("TOTAL");
        car=new JLabel("CART");
          ftot=new JLabel(" FINAL TOTAL :" );
         fcar=new JLabel(" FINAL CART : ");
        add(tot);
        add(car);
        add(ftot);
        add(fcar);
      
        
        
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
    }
    public void actionPerformed(ActionEvent e)
    {
                 
    
        if(e.getSource()==proceed)
        {
          
         price1=Integer.parseInt(p.getText());
        quantity=Integer.parseInt(q.getText());
        total=price1*quantity;
      ftotal=ftotal+total;
      fcart=fcart+quantity;
      tot.setText(" CURRENT ITEM TOTAL : "+total);
      car.setText(" CURRENT QUANTITY : "+quantity);
      ftot.setText(" TOTAL :"+ftotal);
      fcar.setText(" CART : "+fcart);
      p.setText("");
      q.setText("");
      it.setText("");
    }
 
    }

    }
 