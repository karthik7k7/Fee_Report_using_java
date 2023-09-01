package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AccountantSection extends JFrame implements ActionListener 
{
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField tf;
    JPasswordField pf;

    AccountantSection()
        {
            super("Admin Section");
            setLocation(100,100);
            setSize(400,350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            f = new Font("Arial",Font.BOLD,30);
            f1 = new Font("Arial",Font.BOLD,20);

            l1 = new JLabel("Accountant Section");
            l1.setHorizontalAlignment(JLabel.CENTER);

            b1 = new JButton("Add Student");
            b2 = new JButton("View student");
            b3 = new JButton("Edit Student");
            b4 = new JButton("Due Fees");
            b5 = new JButton("Logout");
            b6 = new JButton("Back");

            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);

            ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("FeeReport/Icon/form.png"));
            Image img = i.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            ImageIcon ii = new ImageIcon(img);
            l2 = new JLabel(ii);

            l1.setFont(f);
            b1.setFont(f1);
            b2.setFont(f1);
            b3.setFont(f1);
            b4.setFont(f1);
            b5.setFont(f1);
            b6.setFont(f1);

            p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(6,1,10,10));
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
        p3.add(b5);
        p3.add(b6);

        setLayout(new BorderLayout(10,10));

        add(p1,"North");
        add(p2,"Center");
        add(p3,"East");

        }
    
    
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==b1)
        {
            new AddStudent().setVisible(true);
        }
        if(e.getSource()==b2)
        {
            new ViewStudent().setVisible(true);

        }
        if(e.getSource()==b3)
        {
            new EditStudent().setVisible(true);
        }

        if(e.getSource()==b4)
        {
            new Due().setVisible(true);
        }
        if(e.getSource()==b5)
        {
            this.setVisible(false);
        }
        if(e.getSource()==b6)
        {
            this.setVisible(false);
            new Index().setVisible(true);
        }
    }
    public static void main(String [] args)
    {
        new AccountantSection().setVisible(true);
    }
}
