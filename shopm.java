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
import net.proteanit.sql.DbUtils;
import javax.swing.BorderFactory;
 class shopm
 {
   public static void main()
   {
    shopm1 log = new shopm1();
   }
 }
  class shopm1 extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel u_name,p_name,passign,bg;
   ImageIcon img;
   JTextField uname;
   JPasswordField pname;
   JComboBox post;
   JButton bill,stock,employee,logout;
   
   shopm1()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("SHOP MANAGER");
    c.setVisible(true);  
    c.setSize(1400,850);
    c.setLocationRelativeTo(null);
    c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("shopm.png"));
    bg = new JLabel(img);
    c.add(bg);
    bg.setLayout(null);
    employee=new JButton("<html><font size = '15',color = 'AQUA'>EM</font><font size = '15',color = 'GREEN'>PLOY</font><font size = '15',color = 'ORANGE'>EE</font></html>");
    employee.setBounds(513,487,300,88);
    employee.setOpaque(false);
    employee.setContentAreaFilled(false);
    employee.setBorder(BorderFactory.createLineBorder(Color.GREEN));
 
    stock=new JButton("<html><font size = '15',color = 'AQUA'>STOCK</font></html>");
    stock.setBounds(278,278,300,88);
    stock.setOpaque(false);
    stock.setContentAreaFilled(false);
    stock.setBorder(BorderFactory.createLineBorder(Color.BLUE));
 
    bill=new JButton("<html><font size = '15',color = 'ORANGE'>BILL</font></html>");
    bill.setBounds(746,278,300,88);
    bill.setOpaque(false);
    bill.setContentAreaFilled(false);
    bill.setBorder(BorderFactory.createLineBorder(Color.RED));
 
    logout=new JButton("LOGOUT");
    logout.setBounds(50,55,210,62);
    logout.setOpaque(false);
    logout.setContentAreaFilled(false);
    logout.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 
    bg.add(employee);
    bg.add(stock);
    bg.add(bill);
    bg.add(logout);
   
    bill.addActionListener(this);
    stock.addActionListener(this);
    employee.addActionListener(this);
    logout.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
   {
     if(ae.getSource()==bill)
     {
    JFrame v = new JFrame();
    v.setLayout(new BorderLayout());
    v.setTitle("BILL");
    v.setVisible(true);  
    v.setSize(200,200);
    v.setLocationRelativeTo(null);
    v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JScrollPane sp = new JScrollPane();
    sp.getViewport().setBackground(Color.YELLOW);
    v.add(sp);
    JTable it = new JTable();
    sp.setViewportView(it);
    try
      { 
        Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
       String qery = "SELECT * FROM bill";
      PreparedStatement pst = coon.prepareStatement(qery);
       ResultSet rs = pst.executeQuery();
       it.setModel(DbUtils.resultSetToTableModel(rs));
     
      }
      catch (Exception exception)
    {
        exception.printStackTrace();
    }
           
      }
      if(ae.getSource()==stock)
      {
         JFrame v = new JFrame();
    v.setLayout(new BorderLayout());
    v.setTitle("STOCK");
    v.setVisible(true);  
    v.setSize(500,500);
    v.setLocationRelativeTo(null);
  c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JScrollPane sp = new JScrollPane();
    sp.getViewport().setBackground(Color.YELLOW);
    v.add(sp);
    JTable it = new JTable();
    sp.setViewportView(it);
    try
      { 
        Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
       String qery = "SELECT * FROM item";
      PreparedStatement pst = coon.prepareStatement(qery);
       ResultSet rs = pst.executeQuery();
       it.setModel(DbUtils.resultSetToTableModel(rs));
     
      }
      catch (Exception exception)
    {
        exception.printStackTrace();
    }
        
        }
        if(ae.getSource()==employee)
        {
            RegistrationForm bm = new RegistrationForm();
                         bm.setVisible(true);
                         setVisible(false);
        }
        if(ae.getSource()==logout)
        {
          int result = JOptionPane.showConfirmDialog(logout,"Are you sure you want to logout?", "Stock Checker",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {  
                      welc1 bm = new welc1();
                         bm.setVisible(true);
                         setVisible(false);
             }
        }
     
 
    }
    
   
 }