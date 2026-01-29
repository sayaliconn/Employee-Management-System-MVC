package test;
import java.sql.*;

public class DAOAdminLogin {

    public AdminBean login(String un, String pwd) {
        AdminBean ab = null;

        try {
            Connection con = DBCon.getCon();  // Make sure DBCon.getCon() returns a valid DB connection

            PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?");
            ps.setString(1, un);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ab = new AdminBean();

                ab.setUsername(rs.getString(1));
                ab.setPassword(rs.getString(2));
                ab.setFname(rs.getString(3));
                ab.setLname(rs.getString(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ab;
    }

}
