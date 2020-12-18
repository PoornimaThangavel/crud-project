package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lti.entities.*;

import com.lti.dao.StudentDAO;

/**
 * Servlet implementation class ViewServlet
 */

public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Student> student =StudentDAO.getAllStudents();
		for(Student s : student)
		{
			out.println(s.getName() + " " + s.getPassword() +" " + s.getEmail() + " "+ s.getCountry() + "<br>");
		}
		
		out.println("<a href=\"index.html\">Back</a>");
	}

}
