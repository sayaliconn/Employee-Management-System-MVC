<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin | Operation Status</title>
<style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
    }

    body {
      background: linear-gradient(135deg, #007bff, #00d4ff);
      min-height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      color: #fff;
      flex-direction: column;
    }

    .container {
      background: rgba(255, 255, 255, 0.15);
      backdrop-filter: blur(10px);
      border-radius: 16px;
      padding: 40px 60px;
      text-align: center;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
      width: 420px;
    }

    h2 {
      font-size: 26px;
      margin-bottom: 10px;
      font-weight: 600;
    }

    .msg {
      font-size: 18px;
      margin: 20px 0;
    }

    .btn-container {
      display: flex;
      flex-direction: column;
      gap: 12px;
    }

    a {
      text-decoration: none;
      background-color: #fff;
      color: #007bff;
      font-weight: 600;
      padding: 10px 20px;
      border-radius: 8px;
      transition: 0.3s;
      display: block;
    }

    a:hover {
      background-color: #007bff;
      color: #fff;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
      transform: translateY(-2px);
    }

    footer {
      margin-top: 25px;
      color: #d0eaff;
      font-size: 14px;
    }
</style>
</head>
<body>

  <div class="container">
    <%
        AdminBean ab5 = (AdminBean) session.getAttribute("Bean");
        String msg = (String) request.getAttribute("msg");

        if (ab5 == null) {
            out.println("<h2>Session Expired</h2>");
            out.println("<p>Please <a href='AdminLogin.html' style='color:#fff; text-decoration:underline;'>log in again</a>.</p>");
        } else {
    %>
        <h2>Admin Action Summary</h2>
        <div class="msg">
          <b>Admin:</b> <%= ab5.getFname() %><br>
          <%
              if (msg != null) {
                  out.println("<p style='margin-top:10px;'>" + msg + "</p>");
              } else {
                  out.println("<p>No status message received.</p>");
              }
          %>
        </div>

        <div class="btn-container">
          <a href="addemp.html">Add Employee</a>
          <a href="view">View All Employees</a>
          <a href="logout">Logout</a>
        </div>
    <%
        }
    %>
  </div>
</body>
</html>
