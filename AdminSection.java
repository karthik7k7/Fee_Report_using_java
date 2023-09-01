package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener 
{
    JLabel l1,l2;
    JButton b1,b2,b3;
    JPanel p1,p2;
    Font f,f1;

    AdminSection()
    {
        super("Admin Section");
        setLocation(100,100);
        setSize(400,270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Admin Section");
        l1.setHorizontalAlignment(JLabel.CENTER);

        b1 = new JButton("Add Accountant");
        b2 = new JButton("View Accountant");
        b3 = new JButton("Logout Admin");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("FeeReport/Icon/robot.jpg"));
        Image img = i.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon ii = new ImageIcon(img);
        l2 = new JLabel(ii);

        f = new Font("Arial",Font.BOLD,30);
        f1 = new Font("Arial",Font.BOLD,20);

        l1.setFont(f);
        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4,1,10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);


        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l2);
                
        setLayout(new BorderLayout(10,10));

        add(p1,"Center");
        add(p2,"East");
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new AddAccountant().setVisible(true);
        }
        if(e.getSource()==b2)
        {
            new ViewAccountant().setVisible(true);

        }
        if(e.getSource()==b3)
        {
            this.setVisible(false);
            new Index().setVisible(true);
        }
    }
    public static void main(String [] args)
    {
        new AdminSection().setVisible(true);
    }

}
