<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"
	import ="java.util.*, test.EmployeeBean, test.AdminBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW ALL EMPLOYEE</title>
</head>
<body>
<div class="center-container">
	<%
		AdminBean ab3 = (AdminBean)session.getAttribute("Bean");
		ArrayList<EmployeeBean> al =(ArrayList<EmployeeBean>)session.getAttribute("alist");

		 if (ab3 == null || al == null) {
                out.println("<h3>Session expired or no data available. Please log in again.</h3>");
                return;
            }

		out.println("Page belongs to Admin : "+ab3.getFname()+"<br><br>");

		if(al.size()==0)
    	{
    		out.println("No employee available...<br>");
    	}
    	else{
	%>

	<h2>LIST OF ALL EMPLOYEES</h2>

	<table border="1">

	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>DESIGNATION</th>
		<th>BASIC SALARY</th>
		<th>HRA</th>
		<th>DA</th>
		<th>TOTAL SALARY</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>

	<% for(EmployeeBean eb4 : al){ %>
	<tr>
		<td><%= eb4.getEid() %></td>
		<td><%= eb4.getEname() %></td>
		<td><%= eb4.getDesg() %></td>
		<td><%= eb4.getBsal() %></td>
		<td><%= eb4.getHra() %></td>
		<td><%= eb4.getDa() %></td>
		<td><%= eb4.getTotalsal() %></td>
		<td><a href='edit?eid=<%=eb4.getEid()%>'>EDIT</a>
		<td><a href='delete?eid=<%=eb4.getEid()%>'>DELETE</a></td>



    </tr>
        <% } } %>

        <a href="Login.jsp">BACK</a>

	</table>

</div>
</body>
</html>