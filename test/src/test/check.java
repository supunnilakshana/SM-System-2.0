
package test;
import java.sql.*;
import com.mysql.jdbc.Connection;

public class check {
    public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connectivity is OK...");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
			System.out.println("MYSQL connection is OK...");
		}catch(Exception e){
			System.out.println("ERROR : "+e);
		}
	}
    
}
