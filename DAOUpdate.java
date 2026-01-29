package test;
import java.sql.*;

public class DAOUpdate {
    public int k = 0;

    public int update(EmployeeBean eb) {
        try {
            Connection con = DBCon.getCon();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET bsal=?, hra=?, da=?, totalsal=? WHERE eid=?"
            );

            ps.setFloat(1, eb.getBsal());      // bsal
            ps.setFloat(2, eb.getHra());       // hra
            ps.setFloat(3, eb.getDa());        // da
            ps.setFloat(4, eb.getTotalsal());  // totalsal
            ps.setString(5, eb.getEid());      // eid (WHERE condition)

            k = ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Update failed: " + e.getMessage(), e);
        }
        return k;
    }
}
