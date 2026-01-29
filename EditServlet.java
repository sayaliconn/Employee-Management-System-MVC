package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/edit")
public class EditServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        //This checks if the session exists (important for security —
        // only logged-in users can edit). If session is missing, it redirects to a message page.
        HttpSession hs = req.getSession(false);

        if(hs==null)
        {
            req.setAttribute("msg", "Session expired...<br>");

            req.getRequestDispatcher("Msg.jsp").forward(req, res);
        }else{
            String eid = req.getParameter("eid");
            ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)hs.getAttribute("alist");

            for (EmployeeBean eb : al) /* no iterator required */
            {
                if (eid.equals(eb.getEid())) {
                    hs.setAttribute("ebean", eb);
                    break;
                }
            }
            req.getRequestDispatcher("Edit.jsp").forward(req,res);
        }
    }

}
