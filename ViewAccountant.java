package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewAccountant extends JFrame implements ActionListener
{
    String a[] = {"Name", "Password", "Email", "Contact","Address"};
    String b[] [] = new String [20][5];
    int i = 0, j = 0;
    JTable t;
    Font f,f1;
    JButton b1;
    JPanel p;

    ViewAccountant()
    {
        super("Accountant Section");
        setLocation(1,1);
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f = new Font ("MS UI Gothic",Font.BOLD,15);

        b1= new JButton("Back");
        b1.addActionListener(this);
        b1.setFont(f);

        p = new JPanel();
        p.setLayout(new GridLayout(1,1,10,10));
        p.add(b1);
        add(p,"South");

        try
        {
            ClassConnection obj = new ClassConnection();
            String q = "select *from accountant";
            ResultSet r = obj.stm.executeQuery(q);

            while(r.next())
            {
                b[i][j++]=r.getString("name");
                b[i][j++]=r.getString("password");
                b[i][j++]=r.getString("email");
                b[i][j++]=r.getString("contact");
                b[i][j++]=r.getString("address");
                i++;
                j=0;
            }

            t = new JTable(b,a);
            t.setFont(f);

        }
        
        catch(Exception ee)
        {
            ee.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t);
        add(sp);

    }

    public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==b1)
        {
            this.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }

    public static void main(String [] args)
    {
        new ViewAccountant().setVisible(true);
    }
    
}
