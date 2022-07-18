<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% 
     response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
     String uname = (String)session.getAttribute("uname");
     session.invalidate();
     
     if(uname==null){
    	 System.out.println(uname);
    	 response.sendRedirect("login.jsp");
     }
     %>
</body>
</html>