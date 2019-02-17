
package Customer;

import java.sql.*;
import java.util.LinkedList;

public class OrderChecker {
     public boolean login(String name,String password) 
    {
            boolean success=false;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from orderchecker;");
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
                int i=stmt.executeUpdate("insert into orderchecker values("+id+",\""+uname+"\",\""+pword+"\",\""+mobno+"\");");
                return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
      public boolean approves(String oid)
      {
          try
          {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
                Statement stmt=con.createStatement();
                stmt.executeUpdate("insert into approves values(\""+oid+"\");");
                stmt.executeUpdate("UPDATE oaddress1 SET status = 'y' WHERE oid="+oid+";");
          }
          catch(Exception e)
          {
              return false;
          }
          return true;
      }
      
}
