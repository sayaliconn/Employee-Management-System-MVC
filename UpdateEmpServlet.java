package test;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/update")
public class UpdateEmpServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession hs = req.getSession(false);
        if(hs==null){
            req.setAttribute("msg", "Session expired");
            req.getRequestDispatcher("Msg.jsp").forward(req,res);

        }else{
            String eid = req.getParameter("eid");
            float bs = Float.parseFloat(req.getParameter("bsal"));
            float h = Float.parseFloat(req.getParameter("hra"));
            float d = Float.parseFloat(req.getParameter("da"));
            float hra =(float) (h*bs)/100;
            float da =(float) (d*bs)/100;
            float totalsal = bs+hra+da;

            ArrayList<EmployeeBean> al2 =(ArrayList<EmployeeBean>)hs.getAttribute("alist");
            for(EmployeeBean eb : al2)
            {
                if(eid.equals(eb.getEid())) {
                    eb.setBsal(bs);
                    eb.setHra(hra);
                    eb.setDa(da);
                    eb.setTotalsal(totalsal);

                    int k = new DAOUpdate().update(eb);

                    if (k > 0) {
                        req.setAttribute("msg", "Employee updated sucessfully...<br>");
                        break;
                    }
                }
            }
            req.getRequestDispatcher("UpdateEmp.jsp").forward(req,res);
        }
    }
}
