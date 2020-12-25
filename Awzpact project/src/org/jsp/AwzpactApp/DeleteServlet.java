package org.jsp.AwzpactApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		int i=EmpDAO.delete(id);
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='#6495ed'>"+"<h1>Record successfully deleted </h1>"+"<form action='ViewServlet' method='post'>"+"<input type='submit' value='back'></body></html>");
		out.flush();
		out.close();
	}
}
