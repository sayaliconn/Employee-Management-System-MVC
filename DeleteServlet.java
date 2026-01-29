package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        //Check if session exists
        HttpSession hs = req.getSession(false);

        if(hs==null)
        {
            req.setAttribute("msg", "Cannot view employee due to login error");

            req.getRequestDispatcher("Msg.jsp").forward(req, res);
        }else {

            String eid = req.getParameter("eid");

            int k = new DAOdelete().delete(eid);

            if (k > 0) {
                req.setAttribute("msg", "Employee deleted successfully!");
            } else {
                req.setAttribute("msg", "Employee deletion failed.");
            }

            req.getRequestDispatcher("ViewAllEmployee.jsp").forward(req, res);
        }
    }
}
