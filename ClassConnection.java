package FeeReport;

import java.sql.*;

//To connect the project to Database.
public class ClassConnection
{
   //creating public variables.
   Connection con;
   Statement stm;
   
   ClassConnection()
   {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/fees","root","Neha@gawali5");

        //To create statment
        stm = con.createStatement();

        /*if(con.isClosed())
        {
            System.out.println("Not connect");
        }


        else
        {
            System.out.println("connect");
        }*/
    }
    
    catch (Exception e) {
        e.printStackTrace();
    }
   }
   
   public static void main(String []args)
   {
    new ClassConnection();
   }

}