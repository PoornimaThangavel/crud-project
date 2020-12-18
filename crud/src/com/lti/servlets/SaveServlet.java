package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.lti.dao.StudentDAO;
import com.lti.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String country=request.getParameter("country");
		
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCountry(country);
		
		int status = StudentDAO.save(s);
		if(status > 0)
			out.println("<h3>1 record inserted</h3>");
		else
			out.println("<h3>sry</h3>");
	}

}
