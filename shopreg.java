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
 class shop
 {
   public static void main()
   {
    shopreg sr = new shopreg();
   }
 }
 public class shopreg extends JFrame implements ActionListener
 {
   JFrame c;
   JLabel bg,si,sn,on,pn,ei,lm,pc;
   ImageIcon img;
   JTextField ShopId,ShopName,OwnerName,PhoneNo,EmailId,LandMark,PinCode;
   JButton Register;
   shopreg()
   {
    c = new JFrame();
    c.setLayout(new BorderLayout());
    c.setTitle("Shop Registration Form");
    c.setVisible(true);  
    c.setSize(1000,800);
    c.setLocationRelativeTo(null);
   c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    img = new ImageIcon(getClass().getResource("back3.png"));
    bg = new JLabel(img);
    c.add(bg);
    bg.setLayout(null);
    
    si = new JLabel("<html><font color = 'white'>SHOP-ID : </font></html>");
    si.setBounds(262,208,150,30);
    bg.add(si);
    
    ShopId = new JTextField("");
    ShopId.setBounds(412,208,300,30);
    bg.add(ShopId);
    
    sn = new JLabel("<html><font color = 'white'>SHOP-NAME : </font></html>");
    sn.setBounds(262,268,150,30);
    bg.add(sn);
   
    ShopName = new JTextField("");
    ShopName.setBounds(412,268,300,30);
    bg.add(ShopName);
    
    on = new JLabel("<html><font color = 'white'>OWNER-NAME : </font></html>");
    on.setBounds(262,328,150,30);
    bg.add(on);
   
    OwnerName = new JTextField("");
    OwnerName.setBounds(412,328,300,30);
    bg.add(OwnerName);
    
    pn = new JLabel("<html><font color = 'white'>PHONE-NO. : </font></html>");
    pn.setBounds(262,388,150,30);
    bg.add(pn);
   
    PhoneNo = new JTextField("");
    PhoneNo.setBounds(412,388,300,30);
    bg.add(PhoneNo);
    
    ei = new JLabel("<html><font color = 'white'>EMAIL-ID : </font></html>");
    ei.setBounds(262,448,150,30);
    bg.add(ei);
   
    EmailId = new JTextField("");
    EmailId.setBounds(412,448,300,30);
    bg.add(EmailId);
    
    lm = new JLabel("<html><font color = 'white'>CITY/DISTRICT : </font></html>");
    lm.setBounds(262,508,150,30);
    bg.add(lm); 
   
    LandMark = new JTextField("");
    LandMark.setBounds(412,508,300,30);
    bg.add(LandMark);
    
    pc = new JLabel("<html><font color = 'white'>PIN-CODE : </font></html>");
    pc.setBounds(262,568,150,30);
    bg.add(pc);
   
    PinCode = new JTextField("");
    PinCode.setBounds(412,568,300,30);
    bg.add(PinCode);
   
    Register = new JButton("<html><font color ='WHITE'>REGISTER</font></html>");
    Register.setBackground(Color.RED);
    Register.setBounds(437,628,100,30);
    Register.setBorder(BorderFactory.createLineBorder(Color.RED));
   bg.add(Register);
    Register.addActionListener(this);
   
   }
   public void actionPerformed(ActionEvent r)
  {
    String shopid = ShopId.getText();
    String shopname = ShopName.getText();
    String ownername = OwnerName.getText();
    String phone = PhoneNo.getText();
    String email = EmailId.getText();
    String landmark = LandMark.getText();
    String pincode = PinCode.getText();
    String q = "SELECT master_id FROM shop where shop_id='"+shopid+"'";
    try
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String query = "INSERT INTO shop(shop_id,shopname,ownername,phoneno,emailid,city_dist,pincode) values('" + shopid + "','" + shopname + "','" + ownername + "','" +phone+ "','" +email+ "','" +landmark+ "','"+pincode+ "')";
     Statement sta = connection.createStatement();
     int x = sta.executeUpdate(query);
     
     if (x == 0)
     {
       JOptionPane.showMessageDialog(Register,"This  SHOP is already registered");
     }
     else
     {
          Statement st = connection.createStatement();
     ResultSet rs = st.executeQuery(q);
     String data = "";
     while(rs.next())
     {
       data = rs.getInt(1)+"";
             JOptionPane.showMessageDialog(Register,"Welcome, Your SHOP HAS BEEN SUCCESSFULLY REGISTERED.");
              JOptionPane.showMessageDialog(Register,"YOU WILL BE GIVEN YOUR MASTER ID,KEEP THIS ID SAFE AND DO NOT DISCOLOSE THIS ID TO ANYONE");
                     JOptionPane.showMessageDialog(Register,"YOUR MASTER ID IS : "+data);
       
       
     }

     }
     connection.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
    setVisible(true);
  }
 }
    

