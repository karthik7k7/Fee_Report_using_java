package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;

    AddStudent()
    {
        super("Add Student");
        setLocation(100,100);
        setSize(450,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("Arial",Font.BOLD,30);
        f1 = new Font("Arial",Font.BOLD,20);

        l1 = new JLabel("Add Student");
        l2 = new JLabel("Name");
        l3 = new JLabel("Email");
        l4 = new JLabel("Course");
        l5 = new JLabel("Fee");
        l6 = new JLabel("Paid");
        l7 = new JLabel("Due");
        l8 = new JLabel("Address");
        l9 = new JLabel("City");
        l10 = new JLabel("State");
        l11= new JLabel("Country");
        l12= new JLabel("Contact");

        l1.setHorizontalAlignment(JLabel.CENTER);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11= new JTextField();

        b1 = new JButton("Add Student");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        t11.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);
        p2.add(l7);
        p2.add(t6);
        p2.add(l8);
        p2.add(t7);
        p2.add(l9);
        p2.add(t8);
        p2.add(l10);
        p2.add(t9);
        p2.add(l11);
        p2.add(t10);
        p2.add(l12);
        p2.add(t11);

        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));

        add(p1,"North");
        add(p2,"Center");

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String name =  t1.getText();
            String Email = t2.getText();
            String Course = t3.getText();
            float fee = Float.parseFloat(t4.getText());
            float paid = Float.parseFloat(t5.getText());
            float due = Float.parseFloat(t6.getText());
            String Address = t7.getText();
            String city = t8.getText();
            String state = t9.getText();
            String country = t10.getText();
            String cont = t11.getText();

            if(e.getSource()==b1)
            {
                try
                {
                ClassConnection obj = new ClassConnection();
                String q = "insert into addstudent (Name, Email, Course, Fee, Paid, Due, Address, City, State, Country,Contact) value ('"+name+"','"+Email+"','"+Course+"','"+fee+"','"+paid+"','"+due+"','"+Address+"','"+ city+"','"+ state+"','"+country+"','"+ cont+"')";
                int a = obj.stm.executeUpdate(q);

                if(a==1)
                {
                    JOptionPane.showMessageDialog(null,"Sucessfully inserted");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Not Sucessfully inserted");
                    this.setVisible(true);
                }
                }
            
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            }

            if(e.getSource()==b2)
            {
                this.setVisible(false);
                new AccountantSection().setVisible(true);
            }
        }
            
    }
        
    public static void main(String [] args)
    {
        new AddStudent().setVisible(true);
    }

    
}
