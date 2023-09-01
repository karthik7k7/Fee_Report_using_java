package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddAccountant extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField t1,t2,t3,t4;
    JPasswordField pf;

    AddAccountant()
    {
        super("Accountant Section");
        setLocation(100,100);
        setSize(800,370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Add Accountant");
        l2 = new JLabel("Name");
        l3 = new JLabel("Password");
        l4 = new JLabel("Email");
        l5 = new JLabel("Contact");
        l6 = new JLabel("Address");

        l1.setHorizontalAlignment(JLabel.CENTER);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        pf = new JPasswordField();

        b1 = new JButton("Add Accountant");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("FeeReport/Icon/lap.jpg"));
        Image img = i.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon ii = new ImageIcon(img);
        l7 = new JLabel(ii);

        f = new Font("Arial",Font.BOLD,30);
        f1 = new Font("Arial",Font.BOLD,20);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        b1.setFont(f1);
        b2.setFont(f1);
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        pf.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
       
        p2 = new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t3);
        p2.add(pf);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(b1);
        p2.add(b2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l7);

        setLayout(new BorderLayout(10,10));

        add(p1,"North");
        add(p2,"Center");
        add(p3,"East");
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String name =  t1.getText();
            String pass =  pf.getText();
            String Email = t2.getText();
            String Contact = t3.getText();
            String Address = t4.getText();


            try
            {
                ClassConnection obj = new ClassConnection();
                String q = "insert into accountant (Name,Password, Email, Contact, Address) value ('"+name+"','"+pass+"','"+ Email+"','"+ Contact+"','"+Address+"')";
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
            new AdminSection().setVisible(true);
            this.setVisible(false);
        }

    }
        
    public static void main(String [] args)
    {
        new AddAccountant().setVisible(true);
    }
}
