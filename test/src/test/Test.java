/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conf.openweb;
import errocorect.err_Bend;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import value.v_due;

/**
 *
 * @author User
 */
public class Test {
    
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      //  int year = Calendar.getInstance().get(Calendar.YEAR);
       // System.out.println(year);
      // err_Bend a=new err_Bend();
       //a.errSet(5);
       //v_due b =new v_due();
       //b.setTotALL_m("January",2021);
      // b.setTotALL_y(2021);
      // test2 t =new test2();
      openweb web=new openweb();
      
     // web.open();
       
    }
    
}
