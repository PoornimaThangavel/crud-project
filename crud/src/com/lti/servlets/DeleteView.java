package com.lti.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.StudentDAO;

@WebServlet("/DeleteView")
public class DeleteView extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name2=request.getParameter("name2");
		
	
		int status = StudentDAO.delete(name2);
		if(status > 0)
			out.println("<h3>1 record deleted</h3>");
		else
			out.println("<h3>sry</h3>");
		
	}

}
