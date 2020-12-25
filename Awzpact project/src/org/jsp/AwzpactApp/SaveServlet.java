package org.jsp.AwzpactApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String username=req.getParameter("un");
		String eid=req.getParameter("id");
		int id=Integer.parseInt(eid);
		String country=req.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setUsername(username);
		e.setId(id);
		e.setCountry(country);
		
		
		
		int status=EmpDAO.save(e);
		if(status>0) {
			out.print("<h1>Record save successfully!</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
		else {
			out.println("Sorry! Unable to save Record");
		}
		
		//out.println("<body bgcolor='#42f5b6'><a href='login.html'>sign in</a>");
		out.close();	
		
	}

}
