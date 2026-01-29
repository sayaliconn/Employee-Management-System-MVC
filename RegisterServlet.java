package test;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form values
        String eid = request.getParameter("eid");
        String ename = request.getParameter("ename");
        String desg = request.getParameter("desg");

        String bsalStr = request.getParameter("bsal");
        String hraStr = request.getParameter("hra");
        String daStr = request.getParameter("da");

        float bsal = (bsalStr != null && !bsalStr.isEmpty()) ? Float.parseFloat(bsalStr) : 0f;
        float hra = (hraStr != null && !hraStr.isEmpty()) ? Float.parseFloat(hraStr) : 0f;
        float da = (daStr != null && !daStr.isEmpty()) ? Float.parseFloat(daStr) : 0f;

        float totalsal = bsal + hra + da;  // OR get it from form (your choice)

        // Populate Bean
        EmployeeBean emp = new EmployeeBean();
        emp.setEid(eid);
        emp.setEname(ename);
        emp.setDesg(desg);
        emp.setBsal(bsal);
        emp.setHra(hra);
        emp.setDa(da);
        emp.setTotalsal(totalsal);

        // Call DAO
        EmployeeDAO dao = new EmployeeDAO();
        boolean status = dao.registerEmployee(emp);

        if (status) {
            response.getWriter().println("<h3>Employee Registered Successfully!</h3>");
        } else {
            response.getWriter().println("<h3>Registration Failed. Please try again.</h3>");
        }
    }
}
