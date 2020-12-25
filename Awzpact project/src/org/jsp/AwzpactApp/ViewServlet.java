package org.jsp.AwzpactApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<body bgcolor='#6495ed'><a href='index.html'>Add New Employee</a>");
		out.println("<h1>Awzpact Employee List</h1>");
		
		List<Emp> lst=EmpDAO.getAllEmployee();
		
		out.println("<table border='1' width='100%'>");
		
		out.println("<tr><th>Id</th><th>loginName</th><th>Password</th><th>UserName</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		
		for(Emp e:lst) {
			out.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getUsername()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		
		out.close();
		
	}

}
