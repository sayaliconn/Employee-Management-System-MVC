package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        String un = req.getParameter("username");
        String pwd = req.getParameter("password");

      AdminBean ab = new DAOAdminLogin().login(un, pwd);

        if(ab != null)
        {
            //Creating a new session
            HttpSession hs = req.getSession();
            hs.setAttribute("Bean", ab);

            req.getRequestDispatcher("Login.jsp").include(req, res);

        }else {
            req.setAttribute("msg", "Invalid Login process...");

            req.getRequestDispatcher("Msg.jsp").forward(req, res);

        }

    }

}
