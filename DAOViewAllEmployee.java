package test;
import java.sql.*;
import java.util.ArrayList;

public class DAOViewAllEmployee
{
    public ArrayList<EmployeeBean> view()
    {
        ArrayList<EmployeeBean> al = new ArrayList<EmployeeBean>();

        try {
            Connection con = DBCon.getCon();//to access connection with database

            PreparedStatement ps = con.prepareStatement("select * from employee ");

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                EmployeeBean eb4 = new EmployeeBean();

                eb4.setEid(rs.getString(1));
                eb4.setEname(rs.getString(2));
                eb4.setDesg(rs.getString(3));
                eb4.setBsal(rs.getFloat(4));
                eb4.setHra(rs.getFloat(5));
                eb4.setDa(rs.getFloat(6));
                eb4.setTotalsal(rs.getFloat(7));

                al.add(eb4);

            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        return al;
    }
}
