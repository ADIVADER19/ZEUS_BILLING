import java.awt.FlowLayout;
import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.ImageIcon;

 public class gui1
{
    public static void main()
    {
        
    abc obj=new abc();
}
}
class abc extends JFrame
{
    public abc()
    {
         ImageIcon icon= new ImageIcon("dinho.jpg");
        setLayout(new FlowLayout());
        JLabel l=new JLabel(" WELCOME TO APP NAME ");
        JLabel l1=new JLabel(icon);
        pack();
        add(l);
        add(l1);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
}





































































































































































































