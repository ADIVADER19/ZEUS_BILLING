import java.util.*;
public class bill
{
    static void cart(int count1)
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        double total=0.0;
        System.out.println("enter 1 for viweing cart");
        System.out.println(" enter 0 to proceed to checkout ");
        ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println(" number of items in cart = "+count1);
        }
        else if(ch==0)
        {
            bill(total);
        }
        else
        {
            System.out.println(" invalid choice ");
        }
    }
    static void bill(double total1)
    {
        Scanner sc=new Scanner(System.in);
        double bill=0.0;
        char choice1;
        bill=bill+total1;
        System.out.println(" do you wish to continue shopping ");
        choice1=sc.next().charAt(0); 
        if((choice1=='Y')||(choice1=='y'))
        {
        buy();
    }
    else
    {
        System.out.println(" YOUR TOTAL AMOUNT IS = "+bill);
        System.out.println(" THANK YOU FOR SHOPPING WITH US ");
        System.out.println(" PLEASE VISIT US AGAIN ");
    }
}
    static void exit()
    {
        System.out.println(" PROGRAM EXITED ");
    }
    public static void main()
    {
        int count=0;
        double total =0.0;
        int s;
        Scanner sc=new Scanner(System.in);
        System.out.println(" WELCOME TO GENERAL STORES ");
        do
        {       
        System.out.println("**********************************");
        System.out.println(" enter 1 for buying  groceries  ");
        System.out.println(" enter 2 for viewing cart ");
        System.out.println(" enter 3 for bill ");
        System.out.println("enter 4 for exit ");
        System.out.println("**********************************");
        s=sc.nextInt();
        switch(s)
        {
        case 1:
        buy();
        break;
        case 2:
        cart(count);
        break;
        case 3:
        bill(total);
        break;
        case 4:
        exit();
        break;
        default:
        System.out.println(" INVALID OPTION ");
    }
    
}while(s!=4);
}

     static int buy()
    { 
        int s1;
        int count=0;
        double total=0.0;
        do
        {
            Scanner sc=new Scanner(System.in);
        System.out.println("***********BUY GROCERIES*************");
        System.out.println(" enter 1 for biscuits ");
        System.out.println(" enter 2 for chips ");
        System.out.println(" enter 3 for chocolates ");
        System.out.println(" enter 4 for drinks ");
        System.out.println(" enter 5 for snacks ");
        System.out.println(" enter 6 to Proceed to checkout ");
        System.out.println(" enter 7 to exit ");
        s1=sc.nextInt();
        switch(s1)
        {
            case 1:
            {
                int s2,n;
                System.out.println(" BISCUITS ");
                System.out.println(" enter 1 for dark fantasy (30 rs) ");
                System.out.println(" enter 2 for burbon (40 rs)");
                System.out.println(" enter 3 for marie gold (20 rs)");
                System.out.println(" enter 4 for jim jam (25 rs)");
                System.out.println(" enter 5 for oreo (25 rs)");
                s2=sc.nextInt();
                switch(s2)
                {
                    case 1:
                    {
                        System.out.println(" enter quantity of biscuits ");
                        n=sc.nextInt();
                        total=30*n;
                        count=count+n;
                        bill(total);
                        cart(count);
                        break;
                    }
                    case 2:
                    {
                        System.out.println(" enter quantity of biscuits ");
                        n=sc.nextInt();
                        total=40*n;
                        count=count+n;
                        
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 3:
                    {
                        System.out.println(" enter quantity of biscuits ");
                        n=sc.nextInt();
                        total=20*n;
                        count=count+n;
         
                       
                    
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 4:
                    {
                        System.out.println(" enter quantity of biscuits ");
                        n=sc.nextInt();
                        total=25*n;
                        count=count+n;
                        bill(total);
                        cart(count);
                       
                        break;
                    }
                    case 5:
                    {
                        System.out.println(" enter quantity of biscuits ");
                        n=sc.nextInt();
                        count=count+n;
                        total=25*n;
                        bill(total);
                        cart(count);
                       
                        
                        break;
                    }
                    default:
                    {
                        System.out.println(" enter valid choice ");
                        break;
                    }
                }   
           break;
        }
         
         case 2:
            {
                int s2,n1;
                System.out.println(" CHIPS ");
                System.out.println(" enter 1 for LAYS (40 rs) ");
                System.out.println(" enter 2 for DORITOS (50 rs)");
                System.out.println(" enter 3 for PRINGLES (60 rs)");
                System.out.println(" enter 4 for KURKURE (35 rs)");
                System.out.println(" enter 5 for PARLE (20rs)");
                s2=sc.nextInt();
                switch(s2)
                {
                    case 1:
                    {
                        System.out.println(" enter quantity of chips ");
                        n1=sc.nextInt();
                        total=40*n1;
                        count=count+n1;
                        
                        bill(total);//80
                        cart(count);//2
                        
                        break;
                    }
                    case 2:
                    {
                        System.out.println(" enter quantity of chips ");
                        n1=sc.nextInt();
                        total=50*n1;
                        count=count+n1;
                        
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 3:
                    {
                        System.out.println(" enter quantity of chips");
                        n1=sc.nextInt();
                        total=60*n1;
                        count=count+n1;
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 4:
                    {
                        System.out.println(" enter quantity of chips ");
                        n1=sc.nextInt();
                        total=35*n1;
                        count=count+n1;
                        bill(total);
                        cart(count);
                       
                        break;
                    }
                    case 5:
                    {
                        System.out.println(" enter quantity of chips ");
                        n1=sc.nextInt();
                        total=25*n1;
                        count=count+n1;
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    default:{
                        System.out.println(" enter valid choice ");
                    }
                }   
           break;
        }
        case 3:
            {
                int s3,n2;
                System.out.println(" CHOCOLATES");
                System.out.println(" enter 1 for cadbury silk (65 rs) ");
                System.out.println(" enter 2 for galaxy(30 rs)");
                System.out.println(" enter 3 for 5 star (10 rs)");
                System.out.println(" enter 4 for kit kat (10 rs)");
                System.out.println(" enter 5 for dark chocolate(50 rs)");
                s3=sc.nextInt();
                switch(s3)
                {
                    case 1:
                    {
                        System.out.println(" enter quantity of chocolates");
                        n2=sc.nextInt();
                        total=65*n2;
                        count=count+n2;
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 2:
                    {
                        System.out.println(" enter quantity of chocolates ");
                        n2=sc.nextInt();
                        total=30*n2;
                        count=count+n2;
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 3:
                    {
                        System.out.println(" enter quantity of chocolates");
                        n2=sc.nextInt();
                        total=10*n2;
                        count=count+n2;
                        bill(total);
                        cart(count);
                       
                        break;
                    }
                    case 4:
                    {
                        System.out.println(" enter quantity of chocolates ");
                        n2=sc.nextInt();
                        total=10*n2;
                        count=count+n2;
                     
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 5:
                    {
                        System.out.println(" enter quantity of chocolates ");
                        n2=sc.nextInt();
                        total=10*n2;
                        count=count+n2;
                  
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    default:
                        System.out.println(" enter valid choice ");
                    }
           break;
        }
         case 4:
            {
                int s4,n3;
                System.out.println(" DRINKS ");
                System.out.println(" enter 1 for REAL FRUIT JUICE (65 rs) ");
                System.out.println(" enter 2 for MAAZA(30 rs)");
                System.out.println(" enter 3 for STING(10 rs)");
                System.out.println(" enter 4 for MOUNTAIN DEW(10 rs)");
                System.out.println(" enter 5 for jeera soda(20 rs)");
                s4=sc.nextInt();
                switch(s4)
                {
                    case 1:
                    {
                        System.out.println(" enter quantity of drinks");
                        n3=sc.nextInt();
                        total=65*n3;
                        count=count+n3;
                        bill(total);
                        cart(count);
                      
                        break;
                    }
                    case 2:
                    {
                        System.out.println(" enter quantity of drinks ");
                        n3=sc.nextInt();
                        total=30*n3;
                        count=count+n3;
                       
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 3:
                    {
                        System.out.println(" enter quantity of drinks");
                        n3=sc.nextInt();
                        total=10*n3;
                        count=count+n3;
                      
                        bill(total);
                        cart(count);
         
                        break;
                    }
                    case 4:
                    {
                        System.out.println(" enter quantity of drinks ");
                        n3=sc.nextInt();
                        total=10*n3;
                        count=count+n3;
                       
                        bill(total);
                        cart(count);
           
                        break;
                    }
                    case 5:
                    {
                        System.out.println(" enter quantity of drinks");
                        n3=sc.nextInt();
                        total=10*n3;
                        count=count+n3;
                       
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    default:
                        System.out.println(" enter valid choice ");
                        break;
                }   
           break;
        }
         case 5:
            {
                int s5,n4;
                System.out.println(" SNACKS");
                System.out.println(" enter 1 for BHUJIA SEV (40 rs) ");
                System.out.println(" enter 2 for CHAKALI(30 rs)");
                System.out.println(" enter 3 for  chuda sev(30 rs)");
                System.out.println(" enter 4 for bhakarwadi(30 rs)");
                System.out.println(" enter 5 for  shankarpali(60 rs");
                s5=sc.nextInt();
                switch(s5)
                {
                    case 1:
                    {
                        System.out.println(" enter quantity of snacks");
                        n4=sc.nextInt();
                        total=40*n4;
                        count=count+n4;
                       
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 2:
                    {
                        System.out.println(" enter quantity of snacks ");
                        n4=sc.nextInt();
                        total=30*n4;
                        count=count+n4;
                       
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 3:
                    {
                        System.out.println(" enter quantity of snacks");
                        n4=sc.nextInt();
                        total=30*n4;
                        count=count+n4;
                     
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 4:
                    {
                        System.out.println(" enter quantity of snacks ");
                        n4=sc.nextInt();
                        total=60*n4;
                        count=count+n4;
                   
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    case 5:
                    {
                        System.out.println(" enter quantity of snacks ");
                        n4=sc.nextInt();
                        total=10*n4;
                        count=count+n4;
                 
                        bill(total);
                        cart(count);
                        
                        break;
                    }
                    default:
                        System.out.println(" enter valid choice ");
                        break;
                }   
           break;
        }
        case 6:
        {
            bill(count);
            break;
        }
        case 7:
        {
            System.out.println(" EXITED BILLING ");
            break;
        }    
        }
    }  while(s1==7);    
return 0;
}
}