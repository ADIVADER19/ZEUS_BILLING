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
 public class about
{
    public static void main()
    {
        
    about1 obj=new about1();
}
}
class about1 extends JFrame
{
    public about1()
    {
         ImageIcon icon= new ImageIcon("about.png");
        
        JLabel l1=new JLabel(icon);
        pack();
       
        add(l1);
        setVisible(true);
        setSize(500,500);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
}
