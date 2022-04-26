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
public  class Registration
 {
   public static void main()
   {
    RegistrationForm frame = new RegistrationForm();
   }
 }
 class RegistrationForm extends JFrame implements ActionListener
{
  JFrame w;
  JLabel c,f_name,l_name,u_name,p_name,ph,mail,gender,dob,passign;
  ImageIcon img;
  JTextField fname,lname,uname,email,phone;
  JPasswordField pname;
  JRadioButton male,female;
  JComboBox year,month,day;
  JComboBox post;
  JButton submit,back,view,delete;
  RegistrationForm()
  {
    w = new JFrame();
    w.setLayout(new BorderLayout());
    w.setTitle("Worker Registration Form");
    w.setVisible(true);  
    w.setSize(840,570);
    w.setLocationRelativeTo(null);
    w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    img = new ImageIcon(getClass().getResource("reg.png"));
    c = new JLabel(img);
    w.add(c);
    f_name = new JLabel("First Name");
    f_name.setBounds(20,50,150,20);
    c.add(f_name);
    fname = new JTextField();
    fname.setBounds(130,50,300,20);
    c.add(fname);
   
    l_name = new JLabel("Last Name");
    l_name.setBounds(20,100,150,20);
    c.add(l_name);
    lname = new JTextField();
    lname.setBounds(130,100,300,20);
    c.add(lname);
   
    u_name = new JLabel("User Name");
    u_name.setBounds(20,150,150,20);
    c.add(u_name);
    uname = new JTextField();
    uname.setBounds(130,150,300,20);
    c.add(uname);
   
    p_name = new JLabel("Password");
    p_name.setBounds(20,200,150,20);
    c.add(p_name);
    pname = new JPasswordField();
    pname.setBounds(130,200,300,20);
    c.add(pname);
   
    ph = new JLabel("Phone No.");
    ph.setBounds(20,250,150,20);
    c.add(ph);
    phone = new JFormattedTextField();
    phone.setBounds(130,250,300,20);
    c.add(phone);
   
    mail = new JLabel("Email ID");
    mail.setBounds(20,300,150,20);
    c.add(mail);
    email = new JTextField();
    email.setBounds(130,300,300,20);
    c.add(email);
   
    gender = new JLabel("Gender");
    gender.setBounds(20,350,150,20);
    c.add(gender);
   
    male = new JRadioButton("Male");
    male.setBounds(120,350,80,20);
   
    female = new JRadioButton("Female");
    female.setBounds(210,350,80,20);
   
    c.add(male);
    c.add(female);
   
    ButtonGroup grp = new ButtonGroup();
    grp.add(male);
    grp.add(female);
   
   
    dob = new JLabel("DOB");
    dob.setBounds(20,400,100,20);
    c.add(dob);
   
    String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String months[]={"Jan","Feb","Mar","Apr","Jun","July","Aug","Sept","Oct","Nov","Dec"};
    String years[]={"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};

    day = new JComboBox(days);
    month = new JComboBox(months);
    year = new JComboBox(years);
    day.setBounds(130,400,50,20);
    month.setBounds(190,400,50,20);
    year.setBounds(250,400,50,20);
    c.add(day);
    c.add(month);
    c.add(year);
   
    passign = new JLabel("Post");
    passign.setBounds(20,450,100,20);
    c.add(passign);
   
    String posts[]={"StockChecker","BillManager"};
    post = new JComboBox(posts);
    post.setBounds(130,450,150,20);
    c.add(post);
   
    submit = new JButton("REGISTER");
    submit.setBounds(20,500,120,20);
    c.add(submit);
   
    submit.addActionListener(this);
    delete=new JButton("DELETE");
    delete.setBounds(160,500,80,20);
    delete.addActionListener(this);
    c.add(delete);
    view = new JButton("VIEW");
    view.setBounds(260,500,80,20);
    view.addActionListener(this);
    c.add(view);
    back=new JButton("BACK");
    back.setBounds(360,500,80,20);
    back.addActionListener(this);
    c.add(back);
  }
  public void actionPerformed(ActionEvent r)
  {
      if(r.getSource()==submit)
      {
    String FirstName = fname.getText();
    String LastName = lname.getText();
    String UserName = uname.getText();
    String Password = pname.getText();
    String PhoneNo = phone.getText();
    String EmailId = email.getText();
    String Gender = "male";
    String msg = uname.getText();
    if(female.isSelected())
                {
                  Gender = "female";
                }
    String DoB = day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem();
    String Job = post.getSelectedItem()+"";
    try
    {
     
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
     String query = "INSERT INTO workers values('" + FirstName + "','" + LastName + "','" + UserName + "','" +Password + "','" +PhoneNo+ "','" +EmailId+ "','"+Gender+ "','"+DoB+"','"+Job+"')";
     Statement sta = connection.createStatement();
     int x=sta.executeUpdate(query);
     
     if (x==0)
     {
       JOptionPane.showMessageDialog(submit,"This account already exists");
     }
     else
     {
       JOptionPane.showMessageDialog(submit,"Welcome, " + msg + "Your account is sucessfully created");
     }
     connection.close();
     }
     catch (Exception exception)
    {
        exception.printStackTrace();
    }
}
   else if(r.getSource()==delete)
    {
      String UserNamee = uname.getText();
      String q = "Delete from workers where UserName=?";
     try
               {
                     Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root", "ADVAIT***");
                    PreparedStatement st = con.prepareStatement(q);
                    st.setString(1, UserNamee);
                           int  x=st.executeUpdate();
                                        if(x>0)
                                        {
                                            JOptionPane.showMessageDialog(delete," EMPLOYEE HAS BEEN SUCCESSFULLY REMOVED FROM THE DATABASE");
                                           
                                        }
                                        else
                                        {
                                             JOptionPane.showMessageDialog(delete," INCORRECT CREDENTIALS");
                                             
                                        }
                }
               catch(SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
    }
    else if(r.getSource()==view)
    {
    JFrame v = new JFrame();
    v.setLayout(new BorderLayout());
    v.setTitle("Worker Registration Form");
    v.setVisible(true);  
    v.setSize(1000,500);
    v.setLocationRelativeTo(null);
   v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JScrollPane sp = new JScrollPane();
    sp.getViewport().setBackground(Color.WHITE);
    v.add(sp);
    JTable it = new JTable();
    sp.setViewportView(it);
    try
      { 
        Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "ADVAIT***");
       String qery = "SELECT * FROM workers";
      PreparedStatement pst = coon.prepareStatement(qery);
       ResultSet rs = pst.executeQuery();
       it.setModel(DbUtils.resultSetToTableModel(rs));
     
      }
      catch (Exception exception)
    {
        exception.printStackTrace();
    }
    }
    else
    {
      new shopm1().setVisible(true);
      setVisible(false);
    }
    w.show();
    c.setVisible(true);
}
}