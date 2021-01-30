/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 
/**
 *
 * @author User
 */
public class dbaction {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String pid,name;
    float price;
    int qty,f=0,sqty;
    
    //dbconnect db=new dbconnect();
    public void setdata(String s){
       con=dbconnect.connection();
       try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM cstock";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if(s.equals( rs.getString("P_ID")))
                {
                    pid=s;
                    name=rs.getString("Name");
                    price=  rs.getFloat("Price");
                    qty=rs.getInt("Quantity");
                    sqty=rs.getInt("Sample_Quantity");
                    f=1;
                    //System.out.println(name+price);
                    break;
                    
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
      
    }
    public String getpid(){
        return pid;
        
    }
    public String getname(){
        return name;
        
    }
    public float getprice(){
        return price;
        
    }
    public int getqty(){
        return qty;
        
    }
     public int getsqty(){
        return sqty;
     }
    public int getf(){
        return f;
        
    }
    
    /*public static void main(String[] args) {
        
                dbaction d=new dbaction();
		d.setdata("a2");
	}*/
   
    
}
