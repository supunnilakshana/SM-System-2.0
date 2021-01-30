/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package value;

/**
 *
 * @author User
 */

    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Use
 */

import conf.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.time.Year;
import java.util.Date;
import javax.swing.JOptionPane;


public class v_due{
    
      Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;
     int totm_q=0 ,totrsm_q=0,totrgm_q=0 ,fr=0,fi=0;
     float totm_v= (float) 0.0,totrsm_v=(float) 0.0,totrgm_v=(float) 0.0;
     
     
     
    public void setTotALL_m(String month , int y){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((month.equals( rs.getString("Month"))) && (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year")))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((month.equals( rs.getString("Month"))) && (typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
    
    //product month
    
     public void setTotP_m(String month , int y, String pid){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((month.equals( rs.getString("Month"))) && (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (pid.equals(rs.getString("P_ID"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((month.equals( rs.getString("Month"))) && (typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (pid.equals(rs.getString("P_ID")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
    // employee month 
     
      public void setTotE_m(String month , int y, String eid){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((month.equals( rs.getString("Month"))) && (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (eid.equals(rs.getString("E_ID"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((month.equals( rs.getString("Month"))) && (typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (eid.equals(rs.getString("E_ID")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
    // area month
       public void setTotA_m(String month , int y, String area){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((month.equals( rs.getString("Month"))) && (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (area.equals(rs.getString("Area"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((month.equals( rs.getString("Month"))) && (typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (area.equals(rs.getString("Area")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
      
   //product year
        public void setTotP_y( int y, String pid){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if( (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (pid.equals(rs.getString("P_ID"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (pid.equals(rs.getString("P_ID")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
     //year employee
     public void setTotE_y( int y, String eid){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if( (typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (eid.equals(rs.getString("E_ID"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if( (typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (eid.equals(rs.getString("E_ID")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }    
        
    // year area
      // area month
       public void setTotA_y( int y, String area){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
        
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (area.equals(rs.getString("Area"))))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))&& (area.equals(rs.getString("Area")))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(totm_q+" "+totm_v);
       
      
    }
     
     
     
     
     
     
      
     
     
    
    //year all
    
     public void setTotALL_y(int y){
        con=dbconnect.connection();
        fr=0;
        fi=0;
        totm_q=0;
        totrsm_q=0;
        totrgm_q=0 ;
        totm_v= (float) 0.0;
        totrsm_v=(float) 0.0;
        totrgm_v=(float) 0.0;
       
        String typeI="INVOICE",typeR="RETURN";
        try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM report";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((typeI.equals(rs.getString("Activity"))) && (y==rs.getInt("Year")))
                {
                
                    totm_q+=rs.getInt("Quantity");
                    totm_v+=(rs.getFloat("Price")*rs.getInt("Quantity"));
                    fi=1;
                    //
                    
                }
                if((typeR.equals(rs.getString("Activity"))) && (y==rs.getInt("Year"))){
                    totrsm_q+=(rs.getInt("R_S_Quantity"));
                    totrsm_v+=(rs.getFloat("Price"))*(rs.getInt("R_S_Quantity"));
                    totrgm_q+=(rs.getInt("R_G_Quantity"));
                    totrgm_v+=(rs.getFloat("Price"))*(rs.getInt("R_G_Quantity"));
                    fr=1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("\n"+totm_q+" "+totm_v);
       
      
    }
    
    
        
    
    public int getInvoiceQty(){
          return totm_q;
        
    }
    public float getInvoiceValue(){
          return totm_v;
        
    }
     public int getStockReturnQty(){
          return totrsm_q;
        
    }
     public int getGrabageReturnQty(){
          return totrgm_q;
        
    }
      public float getStockReturnValue(){
          return totrsm_v;
        
    }
      public float getGarbageReturnValue(){
          return totrgm_v;
        
    }
      public int fr(){
          return fr;
      }
       public int fi(){
          return fi;
      }
          
     
           public String getAreas(String aid){
               String s=" ";
               try
        {
            stmt = con.createStatement();
            
            
            String query = "SELECT * FROM area";
            
            rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                if((aid.equals(rs.getString("A_ID"))))
                {
                
                    s=rs.getString("Areas");
                    break;
                    //
                    
                }
               
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
          return s;

}
           
           
           
       
  }
    



    

