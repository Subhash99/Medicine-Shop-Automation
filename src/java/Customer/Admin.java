/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Admin 
{
    public boolean login(String name,String password) 
    {
            boolean success=false;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from administrator;");
                System.out.println(name+" "+password);
                while(rs.next())
                {
                    if(rs.getString(2).equals(name))
                    {
                        if(rs.getString(3).equals(password))
                        {
                            success=true;
                            break;
                        }
                    }
                }
                rs.close();
                stmt.close();
                con.close();
                
            }
            catch(Exception e)
            {
                
            }
            return success;
    }
    public boolean signUp(String id,String uname,String pword,String p1word,String mobno)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
            Statement stmt=con.createStatement();
            if(!(p1word.equals(pword)))
            {
                return false;
            }
             else
            {
                int i=stmt.executeUpdate("insert into administrator values("+id+",\""+uname+"\",\""+pword+"\",\""+mobno+"\");");
                return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public boolean addMedicine(String mid,String mname,String mquantity,String mdate,String edate,String mcost,String maddress)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into medicine1 values(\""+mid+"\",\""+mname+"\",\""+mquantity+"\",\""+mdate+"\",\""+edate+"\",\""+maddress+"\",\""+mcost+"\");");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
}
