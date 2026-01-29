package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    private static final String url = "jdbc:mysql://localhost:3306/sayalidb";
    private static final String user = "root";
    private static final String pass = "serene";

    private static Connection con = null;

    static {
        try {
            // Load JDBC driver (optional for modern JDBC, but safe to keep)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful: " + con);
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public static Connection getCon() {
        return con;
    }
}
