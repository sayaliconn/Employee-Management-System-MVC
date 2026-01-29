package test;

import java.sql.*;

public class EmployeeDAO {

    public boolean registerEmployee(EmployeeBean emp) {
        boolean status = false;

        try {
            Connection con = DBCon.getCon();  // your DB utility

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employees (eid, ename, desg, bsal, hra, da, totalsal) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, emp.getEid());
            ps.setString(2, emp.getEname());
            ps.setString(3, emp.getDesg());
            ps.setFloat(4, emp.getBsal());
            ps.setFloat(5, emp.getHra());
            ps.setFloat(6, emp.getDa());
            ps.setFloat(7, emp.getTotalsal());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
