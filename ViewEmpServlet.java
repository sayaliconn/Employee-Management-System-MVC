package test;
import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/view")

public class ViewEmpServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession hs = req.getSession(false);// fetches existing session

        if(hs==null)//getSession(false) → returns null if session doesn’t exist.
        {
            req.setAttribute("msg", "Cannot view employee due to login error");

            req.getRequestDispatcher("Msg.jsp").forward(req, res);
        }
        else
        {
            ArrayList<EmployeeBean> al = new DAOViewAllEmployee().view();

            hs.setAttribute("alist", al);

            req.getRequestDispatcher("ViewAllEmployee.jsp").forward(req, res);
        }

    }

}
