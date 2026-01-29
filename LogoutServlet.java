package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);

        if (hs != null) {
            hs.invalidate(); // destroy session
        }

        // Redirect to login page (HTML)
        res.sendRedirect("AdminLogin.html"); // ✅ goes to your login form
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res); // reuse logic
    }
}

/*
package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession hs = req.getSession(false);

        if(hs==null)
        {
            req.setAttribute("msg", "Session expired...<br>");
        }
        else{
            hs.removeAttribute("Bean");
            hs.getAttribute("alist");

            hs.invalidate();//session destroyer
            req.setAttribute("msg", "Logged out Succesfully..<br>");
        }
        req.getRequestDispatcher("Msg.jsp").forward(req, res);


    }
} */
