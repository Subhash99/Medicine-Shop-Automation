package Customer;

import java.sql.*;
import java.util.*;

public class Customer {
    private String name,address,phoneno,id,mail,password;
    public void setName(String name)
    {
        this.name=name;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setPhoneno(String phoneno)
    {
        this.phoneno=phoneno;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public void setMail(String mail)
    {
        this.mail=mail;
    }
    public boolean login(String name,String password) 
    {
            boolean success=false;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
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
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
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
    public boolean validateAmount(String cardNo,String cvv,String mid)
    {
        try
        {
            Map<Integer,Integer> map=new HashMap<>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
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
                        System.out.println((int)m.getKey());
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

    
}

