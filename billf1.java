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
import net.proteanit.sql.DbUtils;
  
class billf1 extends JFrame  implements ActionListener
{
    static int ftotal=0,fcart=0;
    int price1,total,quantity;
    ImageIcon img;
    JComboBox c1;
    JTable b;
    JScrollPane bm;
    JFrame f;
    String ids;
    JTextField q,p,it;
    JLabel l,l1,tot,car,ftot,fcar,bg;
    JButton proceed,logout,bill,refresh;
    
       public static void main(String[] args)
    {
       
 
   billf1 obj=new billf1();
 
}
    billf1()
    {
     
    f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setTitle("BILL SYSTEM");
    f.setVisible(true);  
    f.setSize(1000,900);
    f.setLocationRelativeTo(null);
  f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
     img = new ImageIcon(getClass().getResource("xyz.png"));
    bg = new JLabel(img);
    f.add(bg);
   
    bg.setLayout(null);
    
    logout = new JButton("<html><font size = '5',color = 'YELLOW'>LOGOUT</font></html>");
    logout.setBounds(15,30,110,30);
    bg.add(logout);
    logout.addActionListener(this);
        JLabel i=new JLabel("<html><font size = '5',color = 'YELLOW'>SELECT ITEM</font></html>");
        i.setBounds(20,130,150,30);
        bg.add(i);
        c1 = new JComboBox();
        c1.setBounds(170,130,300,30);
       
           try{
            
              Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
             Statement st = con.createStatement();
             String q = "SELECT ITEM_NAME FROM item";
            ResultSet rs = st.executeQuery(q);
             
        while (rs.next())
        {
          ids = rs.getString(1);
          c1.addItem(ids);
         }
         
         st.close();
     }
catch(Exception e)
{
 }      
          bg.add(c1);
        JLabel p1=new JLabel("<html><font size = '5',color = 'YELLOW'>PRICE : </font></html>");
        p1.setBounds(490,130,100,30);
         bg.add(p1);
        p=new JTextField();
        p.setBounds(610,130,100,30);
        bg.add(p);
        
        JLabel q1=new JLabel("<html><font size = '5',color = 'YELLOW'>QUANTITY  </font></html>");
        q1.setBounds(730,130,100,30);
        bg.add(q1);
        q=new JTextField();
        q.setBounds(850,130,50,30);
        bg.add(q);
        refresh=new JButton("REFRESH");
        refresh.addActionListener(this);
        refresh.setBounds(230,175,150,30);
        bg.add(refresh);
       bill=new JButton("BILL");
        bill.addActionListener(this);
        bill.setBounds(500,175,150,30);
        bg.add(bill);
        proceed=new JButton("PROCEED");
          
        proceed.addActionListener(this);
        proceed.setBounds(730,175,150,30);
        bg.add(proceed);
        tot=new JLabel("TOTAL");
        car=new JLabel("CART");
          ftot=new JLabel(" FINAL TOTAL :" );
         fcar=new JLabel(" FINAL CART : ");
         tot.setBounds(100,680,500,30);
        bg.add(tot);
        car.setBounds(100,730,500,30);
        bg.add(car);
        ftot.setBounds(500,680,500,30);
        bg.add(ftot);
        fcar.setBounds(500,730,500,30);
        bg.add(fcar);
      
        bm = new JScrollPane();
bm.setBounds(100,225,800,400);
bm.getViewport().setBackground(Color.YELLOW);
bg.add(bm);

b = new JTable();
bm.setViewportView(b);     
       
    }
    public void actionPerformed(ActionEvent e)
    {
                 
    
        if(e.getSource()==proceed)
        {
      String ITEMNAME = c1.getSelectedItem()+"";   
      price1=Integer.parseInt(p.getText());
      quantity=Integer.parseInt(q.getText());
      total=price1*quantity;
      ftotal=ftotal+total;
      fcart=fcart+quantity;
      try
      {
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
     int d = data-quantity;
     if(d<0)
     {
       JOptionPane.showMessageDialog(proceed,"You have only " +data+ " item in stock");
     }
     else if(d==0)
     {
       JOptionPane.showMessageDialog(proceed,"Out of stock");
     }
     else
     {
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String q = "Update item set QUANTITY=? where ITEM_NAME=?";
     pst = con.prepareStatement(q);
     pst.setInt(1,d);
     pst.setString(2,ITEMNAME);
     pst.executeUpdate();
     String query1 = "INSERT INTO cart values('" + ITEMNAME+ "','" + total + "','" + quantity + "')";
     Statement sta = con.createStatement();
     int x=sta.executeUpdate(query1);
     String qery = "SELECT * FROM cart";
       PreparedStatement pt = con.prepareStatement(qery);
       ResultSet rs1 = pt.executeQuery();
       b.setModel(DbUtils.resultSetToTableModel(rs1));
     
     tot.setText(" CURRENT ITEM TOTAL : "+total);
      car.setText(" CURRENT QUANTITY : "+quantity);
      ftot.setText(" TOTAL :"+ftotal);
      fcar.setText(" CART : "+fcart);
     }
     pst.close();
     con.close();
      
      p.setText("");
      q.setText("");
      it.setText("");
    }
    catch(Exception a)
    {
    }
}
else if(e.getSource()==bill)
{
     int result = JOptionPane.showConfirmDialog(bill,"Are you sure you want to final bill?", "Bill Manager",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(result == JOptionPane.YES_OPTION)
       {
         JOptionPane.showMessageDialog(bill,"YOUR FINAL BILL IS : "+ftotal+"");
       String q1 = "SELECT id FROM bill where bills='"+ftotal+"'";
    try
    {
     Connection connecti = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String u = "INSERT INTO bill(bills) values('" + ftotal + "')";
     Statement sta = connecti.createStatement();
     int y = sta.executeUpdate(u);
     
    ResultSet r = sta.executeQuery(q1);
     String data = "";
     while(r.next())
     {
       data = r.getInt(1)+"";
       JOptionPane.showMessageDialog(bill,"YOUR BILL ID IS : "+data);
     }
     connecti.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
      try{
    String delete = "Delete from cart";
     Connection conne =  DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "ADVAIT***");
     PreparedStatement del = conne.prepareStatement(delete);
     del.executeUpdate();
      String tb = "SELECT * FROM cart";
       PreparedStatement pt1 = conne.prepareStatement(tb);
       ResultSet rs2 = pt1.executeQuery();
       b.setModel(DbUtils.resultSetToTableModel(rs2));
      tot.setText("TOTAL");
        car.setText("CART");
          ftot.setText(" FINAL TOTAL :" );
         fcar.setText(" FINAL CART : ");    
    p.setText("");
    q.setText("");
    it.setText("");
    }
    catch(Exception r)
    {
      
    }
    }
}
else if(e.getSource()==refresh)
{
  int result = JOptionPane.showConfirmDialog(refresh,"Are you sure you want to refresh?", "Bill Manager",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(result == JOptionPane.YES_OPTION)
       {
      try{
    String delete1 = "Delete from cart";
     Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "ADVAIT***");
     PreparedStatement del1 = conn.prepareStatement(delete1);
     del1.executeUpdate();
      String tb1 = "SELECT * FROM cart";
       PreparedStatement pt2 = conn.prepareStatement(tb1);
       ResultSet rs3 = pt2.executeQuery();
       b.setModel(DbUtils.resultSetToTableModel(rs3));
      tot.setText("TOTAL");
        car.setText("CART");
       ftot.setText(" FINAL TOTAL :" );
      fcar.setText(" FINAL CART : ");    
    p.setText("");
    q.setText("");
    it.setText("");
    }
    catch(Exception r)
    {
      
    }
}
}
else{
        int result = JOptionPane.showConfirmDialog(logout,"Are you sure you want to logout ?", "Bill Manager",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(result == JOptionPane.YES_OPTION)
       {
           new gui4().setVisible(true);
           setVisible(false);
       }
    }

}
}