package org.jsp.AwzpactApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
	  static Connection con=null;
	  static PreparedStatement pstmt=null;
	  
	  static boolean checkUser(String name,String pwd) {
		  boolean st=false;
		  con=EmpDAO.getConnection();
		 try {
		  pstmt=con.prepareStatement("select * from awzpact.emp_details where loginname=? and password=?");
		  pstmt.setString(1, name);
		  pstmt.setString(2, pwd);
		  
		  ResultSet rs=pstmt.executeQuery();
		  st=rs.next();
		  
		 }catch(Exception e) {
		  e.printStackTrace();
	  }
		 return st;
	  }

}
