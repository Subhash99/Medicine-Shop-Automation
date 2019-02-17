package Customer;

import java.sql.*;
import java.util.*;

public class Customer1 {
    private String name,address,phoneno,id,mail,password;
    
    public boolean login(String name,String password) 
    {
            boolean success=false;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from customer;");
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
    public boolean signUp(String id,String uname,String pword,String p1word,String address,String mobno)
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
                int i=stmt.executeUpdate("insert into customer values("+id+",\""+uname+"\",\""+pword+"\",\""+mobno+"\",\""+address+"\");");
                return true;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
   public LinkedList<Integer> view()
   {
       LinkedList<Integer> li=new LinkedList<>();
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement stmt=con.prepareStatement("select id from medicine1");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next())
            {
                li.add(rs.getInt(1));
            }
            
       }
       catch(Exception e)
       {
           
       }
       return li;

   }
    
    
    
    
    
    public boolean validateAmount(String cardNo,String cvv,String mid)
    {
        try
        {
            Map<Integer,Integer> map=new HashMap<>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select cno,cvv from atmcard");
            
            while(rs.next())
            {
                map.put(rs.getInt(1),rs.getInt(2));
            }
            for(Map.Entry m:map.entrySet())
            {  
                
                if((int)m.getKey()==Integer.parseInt(cardNo)) 
                {
                    if( (int)m.getValue()==Integer.parseInt(cvv))
                    {
                        rs=stmt.executeQuery("select cost from medicine1 where id="+mid);
                        rs.next();
                        int amount=rs.getInt(1);
                        rs=stmt.executeQuery("select money from atmcard where cno="+cardNo);
                        rs.next();
                        int money=rs.getInt(1)-amount;
                        stmt.executeUpdate("UPDATE atmcard SET money = "+money+" WHERE cno="+cardNo+";");
                        return true;
                    }
                } 
            }  
        }
        catch(ClassNotFoundException | SQLException e)
        {
            return false;
        }
        return false;
    }
    public boolean order(String n,String n1,String name,String phno,String hno,String village,String mandal,String district,String state,String pincode,String cardNo)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            Statement stmt1=con.createStatement();
            Statement stmt2=con.createStatement();
            ResultSet rs1=stmt2.executeQuery("select id from Customer where name=\""+n1+"\"");
            rs1.next();
            ResultSet rs=stmt.executeQuery("select cost from medicine1 where id="+n);
            rs.next();
            int amount=rs.getInt(1);
            rs=stmt.executeQuery("select money from atmcard where cno="+cardNo);
            rs.next();
            int money=rs.getInt(1)-amount;
            stmt.executeUpdate("UPDATE atmcard SET money = "+money+" WHERE cno="+cardNo+";");
            stmt1.execute("insert into oaddress1 (cid,name,phno,houseno,village,mandal,district,state,pincode,mid) values ("+rs1.getInt(1)+",\""+name+"\",\""+phno+"\",\""+hno+"\",\""+village+"\",\""
            +mandal+"\",\""+district+"\",\""+state+"\",\""+pincode+"\","+n+");");
            rs=stmt.executeQuery("select quantity from medicine1 where id="+n);
            rs.next();
            int i=rs.getInt(1);
            stmt1.executeUpdate("Update medicine1 set quantity="+(i-1)+" where id="+n+";");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
       
    }
    public LinkedList<Integer> viewOrders()
    {
        LinkedList<Integer> al=new LinkedList<>();
        LinkedList<Integer> al1=new LinkedList<>();
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
             Statement stmt1=con.createStatement();
            ResultSet rs1=stmt.executeQuery("select oid from oaddress1");
            ResultSet rs=stmt1.executeQuery("select oid from approves");
            while(rs1.next())
            {
                 al.add(rs1.getInt(1));
            }
            while(rs.next())
            {
                 Iterator<Integer> itr=al.iterator();
                 while(itr.hasNext())
                 {
                     int k=itr.next();
                     if(k==rs.getInt(1))
                     {
                         al1.add(rs.getInt(1));
                     }
                 }
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
        }
        return al1;
        
    }
    public static void main(String ... args)
    {
        Customer1 c=new Customer1();
        c.viewOrders();
    }
}

