/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author User
 */
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

public class test2 {
    
    public void chart(){
        final String fiat = "FIAT";
      final String audi = "AUDI";
      final String ford = "FORD";
      final String speed = "Speed";
      final String millage = "Millage";
      final String userrating = "User Rating";
      final String safety = "safety";
      

      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.setValue( 1.0 , fiat , speed );
    //  dataset.setValue( 3.0 , fiat , userrating );
     // dataset.setValue( 5.0 , fiat , millage );
      //dataset.setValue( 5.0 , fiat , safety );

      dataset.addValue( 5.0 , audi , speed );
    // dataset.addValue( 6.0 , audi , userrating );
    // dataset.addValue( 10.0 , audi , millage );
    // dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed );
     // dataset.addValue( 2.0 , ford , userrating );
      //dataset.addValue( 3.0 , ford , millage );
      //dataset.addValue( 6.0 , ford , safety ); 
      
      JFreeChart jchart = ChartFactory.createBarChart("car","type", "score",dataset, PlotOrientation.VERTICAL, true, true,false);
      
       

      //JFreeChart barChart = ChartFactory.createBarChart(
        // "CAR USAGE STATIStICS", 
         //"Category", "Score", 
        // dataset,PlotOrientation.VERTICAL, 
         //true, true, false);
         ChartFrame cf= new ChartFrame("car", jchart,true);
         cf.setVisible(true);
         cf.setSize(800,640);
         
         
        
    }
   
   public static void main( String[ ] args )throws Exception {
      
         
      //int width = 640;    /* Width of the image */
      // int height = 480;   /* Height of the image */ 
      
      //File BarChart = new File( "BarChart.jpeg" ); 
      //ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
      test2 t=new test2();
       t.chart();
   }
}
