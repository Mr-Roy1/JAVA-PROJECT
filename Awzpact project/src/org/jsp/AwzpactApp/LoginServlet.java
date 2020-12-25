package org.jsp.AwzpactApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String loginname=req.getParameter("nm");
		String password=req.getParameter("pw");
		
		if(Validate.checkUser(loginname,password)) {
			RequestDispatcher rd=req.getRequestDispatcher("ViewServlet");
			rd.forward(req, resp);
			
		}
		else {
			out.println("username or password incorrect");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			
		}
	}
}




  
