package test;

import java.sql.*;

public class DAOAddEmployee
{
    public int k=0;

    public int insert(EmployeeBean eb2)
    {
        try {
            Connection con = DBCon.getCon();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee (eid, ename, desg, bsal, hra, da, totalsal) VALUES (?, ?, ?, ?, ?, ?, ?)");


            ps.setString(1, eb2.getEid());
            ps.setString(2, eb2.getEname());
            ps.setString(3, eb2.getDesg());
            ps.setFloat(4, eb2.getBsal());
            ps.setFloat(5, eb2.getHra());
            ps.setFloat(6, eb2.getDa());
            ps.setFloat(7,eb2.getTotalsal());

            k = ps.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
