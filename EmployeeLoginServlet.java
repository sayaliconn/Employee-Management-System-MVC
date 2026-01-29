package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/loginServlet")
public class EmployeeLoginServlet
{

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String un = req.getParameter("eid");
        String pwd = req.getParameter("password");

        EmployeeBean eb = new EmployeeLoginDAO().log(un, pwd);

        if(eb != null)
        {
            //Creating a new session
            HttpSession hs = req.getSession();
            hs.setAttribute("Bean", eb);

            req.getRequestDispatcher("EmployeeProfile.jsp").include(req, res);

        }else {
            req.setAttribute("msg", "Invalid Login process...");

            req.getRequestDispatcher("Msg.jsp").forward(req, res);

        }

    }

}
