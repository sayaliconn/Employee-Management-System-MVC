<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"
	import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN LOGIN PAGE</title>
</head>
<body>

<%
    AdminBean ab2 = (AdminBean)session.getAttribute("Bean");
    out.println("Page belongs to Admin : " + ab2.getFname() + "<br>");
    String msg =(String)request.getAttribute("xyz");
    out.println(msg);
%>
<a href="addemp.html">ADD EMPLOYEE</a>
<a href="view">VIEW ALL EMPLOYEE</a>
<a href="logout">LOGOUT</a>
</body>
</html>