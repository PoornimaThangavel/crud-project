package com.lti.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.entities.*;
import com.lti.servlets.*;


public class StudentDAO {
   public static Connection getConnection() {
	   Connection conn=null;
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	      conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:OSE","scott","tiger");
	      
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	    return conn;
   }
   
   
   public static List<Student> getAllStudents(){
	   
	   List<Student> student = new ArrayList<>();
	   try {
		   
		   Connection con=StudentDAO.getConnection();
		   PreparedStatement ps = con.prepareStatement("select * from student");
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next())
		   {
			   Student s = new Student();
			   s.setName(rs.getString(1));
			   s.setEmail(rs.getString(2));
			   s.setPassword(rs.getString(3));
			   s.setCountry(rs.getString(4));
			      
			   student.add(s);
		   }
	   }
	   catch(Exception e) {
		   
	   }
	return student;
	   
   }
   
   
   public static int save(Student s) {
	   int status = 0;
	   try {
		   Connection con=StudentDAO.getConnection();
		   PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
		  
		   ps.setString(1,s.getName());
		   ps.setString(2, s.getEmail());
		   ps.setString(3, s.getPassword());
		   ps.setString(4, s.getCountry());
		   
		   status = ps.executeUpdate();
		   ps.close();
		   con.close();
	   
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return status;
	   
   }
   
   public static int update1(String name1,String email1) {
	   int status = 0;
	   try {
		   Connection con=StudentDAO.getConnection();
				   
		   PreparedStatement ps = con.prepareStatement("Update student set email=? where fname=?");
		  
		   ps.setString(1,email1);
		   ps.setString(2,name1);
		   
		   System.out.println(email1 + name1);
		   		   
		   status = ps.executeUpdate();
		   ps.close();
		   con.close();
	   
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return status;
	   
   }
   
   
   public static int delete(String name2) {
	   int status = 0;
	   try {
		   Connection con=StudentDAO.getConnection();
				   
		   PreparedStatement ps = con.prepareStatement("delete from student where fname=?");
		  
		   ps.setString(1,name2);
		   
	  		   
		   status = ps.executeUpdate();
		   ps.close();
		   con.close();
	   
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return status;
	   
   }
   
   
} 
