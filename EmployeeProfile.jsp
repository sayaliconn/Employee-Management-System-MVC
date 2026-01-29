<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="test.EmployeeBean" %>

<%
    EmployeeBean eb = (EmployeeBean) session.getAttribute("eb");

    if (eb == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Profile</title>
</head>
<body>

    <h2>Welcome <%= eb.getUsername() %></h2>

</body>
</html>
