/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.util.Calendar;


/**
 *
 * @author User
 */
public class month {
    public int setdate(){
            Calendar cal = Calendar.getInstance();
            //System.out.println(cal.getTime());
             int month = cal.get(Calendar.MONTH);
            return month;
    
    }
    public String setmonth(){
        Calendar cal = Calendar.getInstance();
            //System.out.println(cal.getTime());
             int i  = cal.get(Calendar.MONTH);
        String m;
        if(i==0){
            
            m="January";
            
        }else if(i==1){
            
            m="February";
        }else if(i==2){
            
            m="March";
        }else if(i==3){
            
            m="April";
        }else if(i==4){
            
            m="May";
         }else if(i==5){
            
            m="June";
            
        }else if(i==6){
            
            m="July";
        }else if(i==7){
            
            m="August";
        }else if(i==8){
            i=8;
            m="September";
            
        }else if(i==9){
            
            m="October";
        }else if(i==10){
            
            m="November";
            
        }else{

            m="December";
        }
        
        return m;
        
    }
    public int get_Year(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year;
    }
    /*public String getmonth(int month){
        return null;
    
    
    } 
    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
       
        int month = cal.get(Calendar.MONTH);
        if (month == Calendar.JANUARY)
        {
            System.out.println("JANUARY");
        }
        if (month == Calendar.FEBRUARY)
        {
            System.out.println("FEBRUARY");
        }
        if (month == Calendar.MARCH)
        {
            System.out.println("MARCH");
        }
        if (month == Calendar.APRIL)
        {
            System.out.println("APRIL");
        }
        if (month == Calendar.MAY)
        {
            System.out.println("MAY");
        }
        if (month == Calendar.JUNE)
        {
            System.out.println("JUNE");
        }
        if (month == Calendar.JULY)
        {
            System.out.println("JULY");
        }
        if (month == Calendar.AUGUST)
        {
            System.out.println("AUGUST");
        }
        if (month == Calendar.SEPTEMBER)
        {
            System.out.println("SEPTEMBER");
        }
        if (month == Calendar.OCTOBER)
        {
            System.out.println("OCTOBER");
        }
        if (month == Calendar.NOVEMBER)
        {
            System.out.println("NOVEMBER");
        }
        if (month == Calendar.DECEMBER)
        {
            System.out.println("DECEMBER");
        }
    }*/
    
}
