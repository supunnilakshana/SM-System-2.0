/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errocorect;

import java.util.Calendar;

/**
 *
 * @author User
 */
import conf.dbaction;
import conf.month;
import java.awt.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import conf.dbconnect;
import Menu.menu;

public class err_Bend {
    
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;

    
    String eid,pid,area,date,act,ino;
    int qty,psqty,ssqty,rsqty,rgqty,ano,f=0;
    float price;
    
    public void errSet(int no){
        con=dbconnect.connection();
        ano=no;
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if( no== rs.getInt("A_no"))
                {
                    pid=rs.getString("P_ID") ;
                    eid=rs.getString("E_ID") ;
                    area=rs.getString("Area");
                    date=rs.getString("Date");
                    act=rs.getString("Activity");
                    price=  rs.getFloat("Price");
                    qty=rs.getInt("Quantity");
                    psqty=rs.getInt("PS_Quantity");
                    ssqty=rs.getInt("SS_Quantity");
                    rsqty=rs.getInt("R_S_Quantity");
                    rgqty=rs.getInt("R_G_Quantity");
                    ino=rs.getString("In_No");
                    
                    f=1;
                   System.out.println(pid+" "+eid+" "+area+" "+price+" "+ano+" "+qty+" "+psqty+" "+rsqty+" "+rgqty+" "+act+" "+ssqty+" "+ino);
                    break;
                    
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    public String getPid (){
         return pid;
        
    }
     public String geteid (){
         return eid;
        
    }
     
    public String getArea (){
         return area;
        
    }
    public String getDate (){
         return date;
        
    }
    public String  getAct (){
         return act;
        
    }
    public float getPrice (){
         return price ;
        
    }
    public int getQty(){
         return qty;
        
    }
    public int getPsqty(){
         return psqty ;
         
    }
    public int getSsqty(){
         return ssqty;
        
    }
    public int getRsqty(){
         return rsqty;
         
    }
    
    public int getGsqty(){
         return rgqty;
         
    }
    
     public int getf(){
         return f;
         
    }
    
     public String getino(){
         return ino;
         
     }
    public int errCorrection(){
        String type ="ERROR";
        dbaction stock=new dbaction();
        stock.setdata(pid);
        int cqty=stock.getqty();
        int csqty=stock.getsqty();
        System.out.println(cqty+" "+csqty);
        int nqty,nsqty,t=0;
        
        if(act.equals("PURCHASE")){
            nqty=cqty-qty;
            if(psqty!=0){
                 nsqty=csqty-psqty;
            }else{
                nsqty=0;
            }
            
            
            System.out.println(nqty+" "+nsqty);
            
            
            try
                {
                    
                     stmt = con.createStatement();

                    String query = "UPDATE cstock SET Quantity = ?, Sample_Quantity = ? WHERE P_ID = ?";//update cstock

                    PreparedStatement preparedStmt = con.prepareStatement(query);

                    preparedStmt.setInt(1, nqty);
                    preparedStmt.setInt(2, nsqty);
                    preparedStmt.setString(3,pid);

                    preparedStmt.executeUpdate();
                    
                     String query1 = "UPDATE report SET Activity = ? WHERE A_no = ?";//update report

                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);

                         
                    preparedStmt1.setString(1,type);
                    preparedStmt1.setInt(2, ano); 

                    preparedStmt1.executeUpdate();
                    t=1;
                    
                 }
                catch(Exception e)
                {
                    
                    
                    
                    System.out.println(e);
                }
            
            
        }else if(act.equals("DISPATCH")){
            
                        nqty=cqty+qty;
            if(psqty!=0){
                 nsqty=csqty+psqty;
            }else{
                nsqty=0;
            }
            if(ssqty!=0){
                nqty+=ssqty;
            }
            System.out.println(nqty+" "+nsqty);
            
            
            try
                {
                    
                     stmt = con.createStatement();

                    String query = "UPDATE cstock SET Quantity = ?, Sample_Quantity = ? WHERE P_ID = ?";//update cstock

                    PreparedStatement preparedStmt = con.prepareStatement(query);

                    preparedStmt.setInt(1, nqty);
                    preparedStmt.setInt(2, nsqty);
                    preparedStmt.setString(3,pid);

                    preparedStmt.executeUpdate();
                    
                     String query1 = "UPDATE report SET Activity = ? WHERE A_no = ?";//update report

                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);

                         
                    preparedStmt1.setString(1,type);
                    preparedStmt1.setInt(2, ano); 

                    preparedStmt1.executeUpdate();
                    t=1;
                    
                 }
                catch(Exception e)
                {
                    
                    
                    
                    System.out.println(e);
                }
            
            
            t=1;
        }else if(act.equals("INVOICE")){
            
            try
                {
                    
                     stmt = con.createStatement();

                    
                     String query1 = "UPDATE report SET Activity = ? WHERE A_no = ?";//update report

                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);

                         
                    preparedStmt1.setString(1,type);
                    preparedStmt1.setInt(2, ano); 

                    preparedStmt1.executeUpdate();
                    t=1;
                    
                 }
                catch(Exception e)
                {
                    
                    
                    
                    System.out.println(e);
                }
            
            
           t=1;
           
        }else if(act.equals("RETURN")){
           
            nqty=cqty-rsqty;
            
             
            try
                {
                    
                     stmt = con.createStatement();

                    String query = "UPDATE cstock SET Quantity = ? WHERE P_ID = ?";//update cstock

                    PreparedStatement preparedStmt = con.prepareStatement(query);

                    preparedStmt.setInt(1, nqty);
                    preparedStmt.setString(2,pid);

                    preparedStmt.executeUpdate();
                    
                     String query1 = "UPDATE report SET Activity = ? WHERE A_no = ?";//update report

                    PreparedStatement preparedStmt1 = con.prepareStatement(query1);

                         
                    preparedStmt1.setString(1,type);
                    preparedStmt1.setInt(2, ano); 

                    preparedStmt1.executeUpdate();
                    t=1;
                    
                 }
                catch(Exception e)
                {
                    
                    
                    
                    System.out.println(e);
                }
            
            
            
            
            t=1;
        }else{
            t=0;
        }
         return t;
        
        
    
}
        
    
    
    
    
    
    
   
    
    
}
