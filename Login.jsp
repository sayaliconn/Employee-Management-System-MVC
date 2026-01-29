<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.AdminBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard | Employee Management System</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
    }

    body {
      background: linear-gradient(135deg, #007bff, #00d4ff);
      color: #fff;
      min-height: 100vh;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: flex-start;
      padding-top: 80px;
    }

    .container {
      background: rgba(255, 255, 255, 0.15);
      backdrop-filter: blur(10px);
      border-radius: 16px;
      padding: 40px 60px;
      text-align: center;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
      width: 450px;
    }

    h2 {
      font-size: 28px;
      margin-bottom: 15px;
      font-weight: 600;
    }

    .welcome {
      font-size: 18px;
      margin-bottom: 30px;
    }

    .btn-container {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    a {
      text-decoration: none;
      background-color: #fff;
      color: #007bff;
      font-weight: 600;
      padding: 12px 20px;
      border-radius: 8px;
      transition: all 0.3s ease;
      display: block;
    }

    a:hover {
      background-color: #007bff;
      color: #fff;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
      transform: translateY(-2px);
    }

    footer {
      margin-top: 40px;
      color: #d0eaff;
      font-size: 14px;
    }
  </style>
</head>
<body>

  <div class="container">
    <%
        AdminBean ab2 = (AdminBean)session.getAttribute("Bean");
        if (ab2 != null) {
    %>
        <h2>Admin Dashboard</h2>
        <div class="welcome">Welcome, <strong><%= ab2.getFname() %></strong> 👋</div>
    <%
        } else {
    %>
        <h2>Session Expired</h2>
        <div class="welcome">Please <a href="AdminLogin.html" style="color:#fff; text-decoration:underline;">log in again</a>.</div>
    <%
        }
    %>

    <div class="btn-container">
      <a href="addemp.html">Add Employee</a>
      <a href="view">View All Employees</a>
      <a href="logout">Logout</a>
    </div>
  </div>
</body>
</html>
