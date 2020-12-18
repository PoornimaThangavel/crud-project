<%@ page import="java.io.*"  import="com.lti.entities.*"  import="com.lti.dao.*" import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
   <% 
   List<Student> student =StudentDAO.getAllStudents();
   for(Student s : student)
	{
		out.println(s.getName() + " " + s.getPassword() +" " + s.getEmail() + " "+ s.getCountry() + "<br>");
	}
   %>
   
   <a href="index.jsp">Back</a>
   
</body>
</html>