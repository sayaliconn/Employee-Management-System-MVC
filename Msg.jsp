<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="test.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Login Response | Employee Management System</title>
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
      flex-direction: column;
      color: #fff;
    }

    .container {
      background: rgba(255, 255, 255, 0.15);
      backdrop-filter: blur(10px);
      border-radius: 16px;
      padding: 40px 60px;
      text-align: center;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
      width: 400px;
    }

    h2 {
      font-size: 26px;
      margin-bottom: 10px;
      font-weight: 600;
    }

    .message {
      font-size: 18px;
      margin-bottom: 25px;
    }

    .back-link {
      margin-top: 20px;
    }

    .back-link a {
      color: #fff;
      background-color: #007bff;
      text-decoration: none;
      padding: 10px 20px;
      border-radius: 8px;
      transition: 0.3s;
      font-weight: 600;
    }

    .back-link a:hover {
      background-color: #fff;
      color: #007bff;
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
    <h2>Admin Login Status</h2>

    <div class="message">
      <%
          String str = (String) request.getAttribute("msg");
          if (str != null) {
              out.print(str);
          } else {
              out.print("No message received from server.");
          }
      %>
    </div>

    <div class="back-link">
      <a href="AdminLogin.html">← Back to Login</a>
    </div>
  </div>

</body>
</html>
