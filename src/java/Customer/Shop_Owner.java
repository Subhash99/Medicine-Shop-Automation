package Customer;

import static java.lang.System.out;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class Shop_Owner {

    private String name,id,passwd,address,mob_no;

    public Shop_Owner() {
         //To change body of generated methods, choose Tools | Templates.
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }
    public String getPasswd(){
        return passwd;
    }
    public void setMob(String mob_no){
        this.mob_no=mob_no;
    }
    public String getMob(){
        return mob_no;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public boolean Register(String name,String passwd,String mob_no,String address,String id){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/project","root","root");   
            Statement stmt=con.createStatement();  
            int i=stmt.executeUpdate("insert into shopowner1 values(\""+name+"\",\""+id+"\",\""+passwd+"\",\""+mob_no+"\",\""+address+"\");");
            stmt.close();
            con.close();
            return true;
        }
        catch(Exception e){
            
        }
        return false;
        
    }
    public boolean Login(String name,String passwd){
        int i=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/project","root","root");   
            Statement stmt=con.createStatement(); 
            ResultSet rs=stmt.executeQuery("select name,passwd from shopowner1;");
            while(rs.next()){
                if(rs.getString(1).equals(name) && rs.getString(2).equals(passwd)){
                    return true;
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            
        }
        return false;
    }
    public void view_Medicine_Status(){
            try
            {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/project","root","root");   
            Statement stmt=con.createStatement(); 
            ResultSet rs=stmt.executeQuery("select * from medicine;");
            while(rs.next()){
                    out.println("Medicine Id:"+rs.getString(1)+"Medicine name:"+rs.getString(2)+"Vendor address:"+rs.getString(3)+"Manfacture date:"+rs.getString(4)+"Expiry date:"+rs.getString(5)+"Quantity left:"+rs.getString(6)+"<br>");
           
            }
            }
            catch(Exception e)
            {
                
            }
    }
    public void order_Medicine(String name,String phone_no,String house_no,String village,String mandal,String district,String state,String pincode,int amount){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sonoo","root","root");   
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("insert into order values(\""+name+"\",\""+phone_no+"\",\""+house_no+"\",\""+village+"\",\""+mandal+"\",\""+district+"\",\""+state+"\",\""+pincode+"\",\""+amount+"\")");
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            
        }
    }
    public void make_Payment(String name,String id,String order_id){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sonoo","root","root");   
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("");
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            
        }
    }
    public  LinkedList<String> view()
    {
       LinkedList<String> li=new LinkedList<>();
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement stmt=con.prepareStatement("select id from smedicine where quantity<'40' or edate<='2005-06-05';");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next())
            {
                System.out.println(rs.getString(1));
                li.add(rs.getString(1));
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
    public  boolean order(String n,String n1,String name,String phno,String hno,String village,String mandal,String district,String state,String pincode,String cardNo)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            Statement stmt=con.createStatement();
            Statement stmt1=con.createStatement();
            Statement stmt2=con.createStatement();
            ResultSet rs1=stmt2.executeQuery("select id from shopowner1 where name=\""+n1+"\"");
            rs1.next();
            ResultSet rs=stmt.executeQuery("select cost from smedicine where id="+n);
            rs.next();
            int amount=rs.getInt(1);
            rs=stmt.executeQuery("select money from atmcard where cno="+cardNo);
            rs.next();
            int money=rs.getInt(1)-amount;
            stmt.executeUpdate("UPDATE atmcard SET money = "+money+" WHERE cno="+cardNo+";");
            stmt1.execute("insert into soaddress (sid,name,phno,houseno,village,mandal,district,state,pincode,mid) values ("+rs1.getInt(1)+",\""+name+"\",\""+phno+"\",\""+hno+"\",\""+village+"\",\""
            +mandal+"\",\""+district+"\",\""+state+"\",\""+pincode+"\","+n+");");
            rs=stmt.executeQuery("select quantity from smedicine where id="+n);
            rs.next();
            int i=rs.getInt(1);
            stmt1.executeUpdate("Update smedicine set quantity="+(i-1)+" where id="+n+";");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
}
    

