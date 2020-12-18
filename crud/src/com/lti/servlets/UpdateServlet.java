package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.StudentDAO;
import com.lti.entities.Student;
import com.lti.dao.*;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name1");
		String email=request.getParameter("email1");
		
		out.println(name+  " " +email);
	
		int status = StudentDAO.update1(name,email);
		if(status > 0)
			out.println("<h3>1 record updated</h3>");
		else
			out.println("<h3>sry</h3>");
		
	}

}
