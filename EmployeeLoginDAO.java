package test;

import java.sql.*;

public class EmployeeLoginDAO
{
    public EmployeeBean log(String id, String pass)
    {
        EmployeeBean eb = null;

        try {
            Connection con = DBCon.getCon();  // Make sure DBCon.getCon() returns a valid DB connection

            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE eid=? AND password=?");
            ps.setString(1, id);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                eb = new EmployeeBean();

                eb.setEid(rs.getString(1));
                eb.setPassword(rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eb;
    }
}

