package org.jsp.AwzpactApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static int save(Emp e) {
	   int status=0;
		try {
		    Connection con=EmpDAO.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into awzpact.emp_details (id,loginname,password,username,Country) values(?,?,?,?,?)");
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getName());
			pstmt.setString(3, e.getPassword());
			pstmt.setString(4, e.getUsername());
			pstmt.setString(5, e.getCountry());
		status =  pstmt.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		    return status;
	}
	
	public static int update(Emp e) {
		int status=0;
		try {
		  Connection con=EmpDAO.getConnection();
		  PreparedStatement pstmt=con.prepareStatement("update awzpact.emp_details set loginname=?,password=?,username=?,country=? where id=?");
		  pstmt.setString(1, e.getName());
		  pstmt.setString(2, e.getPassword());
		  pstmt.setString(3, e.getUsername());
		  pstmt.setString(4, e.getCountry());
		  pstmt.setInt(5, e.getId());
		  status=pstmt.executeUpdate();
		  con.close();
		  
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
		
	}
	
	public static int delete(int id) {
		int status=0;
	  try {
		  Connection con=EmpDAO.getConnection();
		  PreparedStatement pstmt=con.prepareStatement("delete from awzpact.emp_details where id=?");
		  pstmt.setInt(1, id);
		  status=pstmt.executeUpdate();
		  con.close();
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return status;
		
	}
	
	public static Emp getEmployeeId(int id) {
		Emp e=new Emp();
		try {
		  Connection con=EmpDAO.getConnection();
		PreparedStatement pstmt=con.prepareStatement("select * from awzpact.emp_details where id=?");
		pstmt.setInt(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setUsername(rs.getString(4));
			e.setCountry(rs.getString(5));
		}
		con.close();
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return e;
		
	}
	
	public static List<Emp> getAllEmployee(){
		List<Emp> lst=new ArrayList<Emp>();
	try {
		Connection con=EmpDAO.getConnection();
		PreparedStatement pstmt=con.prepareStatement("select * from awzpact.emp_details");
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setUsername(rs.getString(4));
			e.setCountry(rs.getString(5));
			lst.add(e);
			
		}
		con.close();
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return lst;
	}
}
