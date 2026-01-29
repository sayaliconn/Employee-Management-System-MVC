<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Edit Employee | Admin Panel</title>
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
      color: #333;
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
      color: #fff;
      margin-bottom: 25px;
      font-size: 26px;
      font-weight: 600;
      letter-spacing: 1px;
    }

    label {
      display: block;
      text-align: left;
      color: #fff;
      font-weight: 500;
      margin-top: 12px;
      margin-bottom: 6px;
    }

    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 10px;
      border-radius: 8px;
      border: 1px solid #ccc;
      font-size: 15px;
      margin-bottom: 12px;
    }

    input[type="submit"] {
      width: 100%;
      padding: 12px;
      background-color: #fff;
      color: #007bff;
      font-weight: 600;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: 0.3s;
      font-size: 16px;
      margin-top: 10px;
    }

    input[type="submit"]:hover {
      background-color: #007bff;
      color: #fff;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
      transform: translateY(-2px);
    }

    .back-link {
      margin-top: 15px;
    }

    .back-link a {
      color: #fff;
      text-decoration: none;
      font-weight: bold;
      transition: 0.3s;
    }

    .back-link a:hover {
      text-decoration: underline;
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
        EmployeeBean eb2 = (EmployeeBean)session.getAttribute("ebean");
        if (eb2 != null) {
    %>
        <h2>✏️ Edit Employee Details</h2>
        <form action="update" method="post">
            <input type="hidden" name="eid" value="<%= eb2.getEid() %>">

            <label for="bsal">Basic Salary</label>
            <input type="text" id="bsal" name="bsal" value="<%= eb2.getBsal() %>" required>

            <label for="hra">HRA (1 - 100)</label>
            <input type="text" id="hra" name="hra" value="<%= eb2.getHra() %>" required>

            <label for="da">DA (1 - 100)</label>
            <input type="text" id="da" name="da" value="<%= eb2.getDa() %>" required>

            <input type="submit" value="Update Employee">
        </form>

        <div class="back-link">
          <a href="view">← Back to Employee List</a>
        </div>
    <%
        } else {
            out.println("<h2>No employee data found.</h2>");
            out.println("<div class='back-link'><a href=\"view\">← Back to Employee List</a></div>");
        }
    %>
  </div>
</body>
</html>
