package FeeReport;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewStudent extends JFrame implements ActionListener
{
    String a[] = {"Roll_No","Name", "Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact",};
    String b[] [] = new String [20][12];
    int i = 0, j = 0;
    JTable t;
    Font f,f1;
    JButton b1;
    JPanel p;

    ViewStudent()
    {
        super("Student Information");
        setLocation(1,1);
        setSize(1300,400);
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
            String q = "select *from addstudent";
            ResultSet r = obj.stm.executeQuery(q);

            while(r.next())
            {
                b[i][j++]=r.getString("Roll_no");
                b[i][j++]=r.getString("name");
                b[i][j++]=r.getString("email");
                b[i][j++]=r.getString("Course");
                b[i][j++]=r.getString("Fee");
                b[i][j++]=r.getString("Paid");
                b[i][j++]=r.getString("Due");
                b[i][j++]=r.getString("Address");
                b[i][j++]=r.getString("City");
                b[i][j++]=r.getString("state");
                b[i][j++]=r.getString("country");
                b[i][j++]=r.getString("contact");
                i++;
                j=0;
            }

            t = new JTable(b,a);
            t.setFont(f);

            JScrollPane sp = new JScrollPane(t);
        add(sp);

        }
        
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
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
        new ViewStudent().setVisible(true);
    }
}
