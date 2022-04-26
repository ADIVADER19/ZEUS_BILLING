import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
public class LoginDemo extends JFrame implements ActionListener {
   JPanel panel;
   JLabel user_label, password_label, message;
   JTextField userName_text;
   JPasswordField password_text;
   JButton submit, cancel;
   LoginDemo() {
      user_label = new JLabel();
      user_label.setText("Enter your User Name :");
      userName_text = new JTextField();
      password_label = new JLabel();
      password_label.setText("Enter your Password :");
      password_text = new JPasswordField();
      submit = new JButton("SUBMIT");
      panel = new JPanel(new GridLayout(8, 1));
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      message = new JLabel();
      panel.add(message);
      panel.add(submit);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
      
      submit.addActionListener(this);
      add(panel, BorderLayout.CENTER);
      setTitle("LOGIN FOR ADMIN!");
      setSize(450,350);
      setVisible(true);
   }
   public static void main() {
      new LoginDemo();
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
         message.setText(" Hello " + userName + "");
      } else {
         message.setText(" Invalid user.. ");
      }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}