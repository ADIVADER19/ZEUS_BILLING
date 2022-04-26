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
public class stockchecker
 {
   public static void main(String args[])
   {
    sc f = new sc();
   }
 }
 class sc extends JFrame implements ActionListener
 {
   Connection con = null;
   PreparedStatement pst = null;
   ResultSet rs = null;
   JFrame f;
   ImageIcon img;
   JLabel bg,i,q;
   JTextField in,qy;
   JButton add,update,delete,view,reset,logout;
   JTable it;
   JScrollPane sp;
   sc()
   {
    f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setTitle("MANAGING STOCKS");
    f.setVisible(true);  
    f.setSize(1000,500);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    img = new ImageIcon(getClass().getResource("stock.png"));
    bg = new JLabel(img);
    f.add(bg);
   
    bg.setLayout(null);
    
    logout = new JButton("<html><font  color = 'DodgerBlue'>LOGOUT</font></html>");
    
    logout.setBounds(15,25,110,50);
        logout.setOpaque(false);
logout.setContentAreaFilled(false);
logout.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    bg.add(logout);

    logout.addActionListener(this);
       
    i = new JLabel("<html><font  color = 'DodgerBlue'>ENTER ITEM NAME</font></html>");
    i.setBounds(100,100,150,30);
    bg.add(i);
   
    in = new JTextField();
    in.setBounds(100,150,300,30);
    bg.add(in);
   
    q = new JLabel("<html><font  color = 'DodgerBlue'>ENTER QUANTITY</font></html>");
    q.setBounds(100,200,150,30);
    bg.add(q);
   
    qy = new JTextField();
    qy.setBounds(100,250,150,30);
    bg.add(qy);
   
    add = new JButton("<html><font  color = 'DodgerBlue'>ADD</font></html>");
    add.setBounds(15,300,110,30);
    add.setOpaque(false);
add.setContentAreaFilled(false);
add.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    bg.add(add);
    add.addActionListener(this);
   
    update = new JButton("<html><font  color = 'DodgerBlue'>UPDATE</font></html>");
    update.setBounds(135,300,110,30);
    update.setOpaque(false);
update.setContentAreaFilled(false);
update.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    bg.add(update);
   update.addActionListener(this);
    delete = new JButton("<html><font color = 'DodgerBlue'>DELETE</font></html>");
    delete.setBounds(255,300,110,30);
    delete.setOpaque(false);
delete.setContentAreaFilled(false);
delete.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    bg.add(delete);
   delete.addActionListener(this);
    view = new JButton("<html><font  color = 'DodgerBlue'>VIEW</font></html>");
    view.setBounds(375,300,110,30);
    view.setOpaque(false);
view.setContentAreaFilled(false);
view.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    bg.add(view);
    
    view.addActionListener(this);
   sp = new JScrollPane();
sp.setBounds(500,20,450,450);
sp.getViewport().setBackground(Color.YELLOW);
sp.setBorder(BorderFactory.createEmptyBorder());
bg.add(sp);

it = new JTable();
sp.setViewportView(it);
             
     }
   

   public void actionPerformed(ActionEvent s)
  {
  if(s.getSource()==add)
   {
    try
    {
     String ItemName = in.getText();
     String Quantity = qy.getText();
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String query = "INSERT INTO item values('" + ItemName + "','" + Quantity + "')";
     Statement sta = con.createStatement();
     int x=sta.executeUpdate(query);
     
     if (x==0)
     {
       JOptionPane.showMessageDialog(add,"This account already exists");
       in.setText("");
qy.setText("");
     }
     else
     {
       JOptionPane.showMessageDialog(add,"ITEM HAS BEEN ADDED INTO THE DATABASE");  
       in.setText("");
qy.setText("");
        }
     con.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
    }
    else if(s.getSource()==delete)
    {
      String ItemName = in.getText();
      String query = "Delete from item where Item_NAME=?";
     try
               {
                     con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "ADVAIT***");
                    PreparedStatement st = con.prepareStatement(query);
                    st.setString(1, ItemName);
                           int r=st.executeUpdate();
                                        if(r>0)
                                        {
                                            JOptionPane.showMessageDialog(delete," ITEM HAS BEEN SUCCESSFULLY REMOVED FROM THE DATABASE");
                                            in.setText("");
qy.setText("");
                                        }
                                        else
                                        {
                                             JOptionPane.showMessageDialog(delete," INCORRECT CREDENTIALS");
                                             in.setText("");
qy.setText("");
                                        }
                }
               catch(SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
    }
    else if(s.getSource()==update)
    {
     try
    {
     String ItemName = in.getText();
     String Quantity = qy.getText();
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String query = "update item set QUANTITY=? where ITEM_NAME=?";
     pst = con.prepareStatement(query);
     pst.setString(1,Quantity);
     pst.setString(2,ItemName);
     pst.executeUpdate();
     JOptionPane.showMessageDialog(update,"Database Updated");
     in.setText("");
qy.setText("");
     con.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
    }
    else if(s.getSource()==view)
    {
      try
      {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
       String qery = "SELECT * FROM item";
       pst = con.prepareStatement(qery);
       rs = pst.executeQuery();
       it.setModel(DbUtils.resultSetToTableModel(rs));
     
      }
      catch (Exception exception)
    {
        exception.printStackTrace();
    }
    }
    else
    {
      int result = JOptionPane.showConfirmDialog(logout,"Are you sure you want to logout?", "Stock Checker",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
               new gui4().setVisible(true);
               f.setVisible(false);
            }  
    }
    }
 }