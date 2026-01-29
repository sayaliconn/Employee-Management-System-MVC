package test;

import java.sql.*;

public class DAOdelete
{
    public int delete(String eid)
    {
        int k = 0;
        try {
            Connection con = DBCon.getCon();

            PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE eid = ?");

            ps.setString(1, eid);

            k = ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Deletion failed: " + e.getMessage(), e);
        }
        return k;
    }
}
