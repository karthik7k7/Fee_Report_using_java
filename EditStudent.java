package FeeReport;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    Choice ch;

    EditStudent()
    {
        super("Edit Student");
        setLocation(100,100);
        setSize(450,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("Arial",Font.BOLD,30);
        f1 = new Font("Arial",Font.BOLD,20);

        ch = new Choice();
        try
        {
            ClassConnection obj = new ClassConnection();
            String q = "select Roll_no from addstudent";
            ResultSet r = obj.stm.executeQuery(q);
            
            while(r.next())
            {
                ch.add(r.getString("Roll_no"));
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }

        l1 = new JLabel("Edit Student");
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
        l13= new JLabel("Roll_no");


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
        l13.setFont(f1); 

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
        p2.setLayout(new GridLayout(13,2,10,10));
        p2.add(l13);
        p2.add(ch);
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

        ch.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ClassConnection obj1 = new ClassConnection();
                    int rn=Integer.parseInt(ch.getSelectedItem());
                    String q1 = "select * from addstudent where Rollno = '"+rn+"'";
                    ResultSet r1 = obj1.stm.executeQuery(q1);
            
            while(r1.next())
            {
                t1.setText(r1.getString("name"));
                t2.setText(r1.getString("email"));
                t3.setText(r1.getString("course"));
                t4.setText(r1.getString("fee"));
                t5.setText(r1.getString("paid"));
                t6.setText(r1.getString("due"));
                t7.setText(r1.getString("address"));
                t8.setText(r1.getString("city"));
                t9.setText(r1.getString("state"));
                t10.setText(r1.getString("country"));
                t11.setText(r1.getString("contact"));
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        }
        }

        );
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            int Roll = Integer.parseInt(ch.getSelectedItem());
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
                ClassConnection obj2 = new ClassConnection();
                String q2 = "UPDATE addstudent SET Name='"+name+"', Email='"+Email+"', Course='"+Course+"', Fee='"+fee+"', Paid='"+paid+"', Due='"+due+"', Address='"+Address+"', City='"+ city+"', State='"+ state+"', Country='"+country+"',Contact='"+ cont+"' where Roll_no='"+Roll+"'";
                int a = obj2.stm.executeUpdate(q2);

                if(a==1)
                {
                    JOptionPane.showMessageDialog(null,"Sucessfully inserted");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Fill Details Carefully");
                    //this.setVisible(true);
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
        new EditStudent().setVisible(true);
    }    
}
