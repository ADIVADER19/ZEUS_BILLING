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
import javax.swing.border.*;
import java.awt.geom.*;
import javax.swing.border.Border;
 class Login
 {
   public static void main(String args[])

   
   {
   
       gui4 log = new        
 gui4();
   }
 }
 public class gui4 extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel welc,bg;
   ImageIcon img;
   JButton next;
   gui4()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("WELCOME");
    c.setVisible(true);  
    c.setSize(700,700);
    c.setLocationRelativeTo(null);
     img = new ImageIcon(getClass().getResource("ZEUSHAND.jpg"));
      c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    bg = new JLabel(img);
    bg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    c.add(bg);
    bg.setLayout(null);
    welc=new JLabel("<html><font size='7' color='YELLOW'>Welcome to ZEUS BILLING</font></html>");
     bg.add(welc);
     welc.setBounds(100,260,500,
     40);
    setLocationRelativeTo(null);
   
    next = new JButton("<html><font color ='YELLOW'>NEXT</font></html>");
    next.setBackground(Color.BLACK);
    next.setBounds(310,330,80,40);
    next.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
    bg.add(next);
    next.addActionListener(this);

           }
 public void actionPerformed(ActionEvent o)
  {

      new LoginForm().setVisible(true);
      c.setVisible(false);

}
}
    
