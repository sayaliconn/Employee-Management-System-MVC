package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/empadd")
public class AddEmpServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        req.setCharacterEncoding("UTF-8");
        HttpSession hs = req.getSession(false);

        if (hs == null) {
            req.setAttribute("msg", "Invalid Login process...");
            req.getRequestDispatcher("Msg.jsp").forward(req, res);
        } else {
            EmployeeBean eb = new EmployeeBean();
            int k = 0; //DECLARE OUTSIDE try BLOCK

            try {
                Float bs = Float.parseFloat(req.getParameter("bsal"));
                Float h = Float.parseFloat(req.getParameter("hra"));
                Float d = Float.parseFloat(req.getParameter("da"));

                h = (h * bs) / 100;
                d = (d * bs) / 100;

                Float totalsal = bs + h + d;

                eb.setEid(req.getParameter("eid"));
                eb.setEname(req.getParameter("ename"));
                eb.setDesg(req.getParameter("desg"));
                eb.setBsal(bs);
                eb.setHra(h);
                eb.setDa(d);
                eb.setTotalsal(totalsal);

                k = new DAOAddEmployee().insert(eb);

            } catch (NumberFormatException e) {
                req.setAttribute("msg", "Invalid number format in input.");
                req.getRequestDispatcher("Msg.jsp").forward(req, res);
                return; // Important to stop execution after forwarding
            }

            if (k > 0) {
                req.setAttribute("xyz", "Employee Added Successfully...<br><br>");
            } else {
                req.setAttribute("xyz", "Error: Employee not added.");
            }

            req.getRequestDispatcher("EmployeeAdded.jsp").forward(req, res);
        }
    }
}





//Summary of session handling:
//
//In AdminServlet:
//HttpSession hs = req.getSession();
//→ Creates a new session for the admin upon successful login.
//
//In AddEmployeeServlet:
//HttpSession hs = req.getSession(false);
//→ Retrieves the existing session without creating a new one.
//→ Ensures we use the same session created during login.
//→ If no session exists (e.g., user is not logged in), it returns null.
//
//Best Practice:
//- Always create a session explicitly during login.
//- Use getSession(false) later to safely access it.
//- This prevents unnecessary session creation and avoids memory overhead.
//- Java does not support nested sessions; all user data (admin/employee) should be stored as attributes within the same session.

