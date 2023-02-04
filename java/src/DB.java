import java.sql.*;

public class DB {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/Electronic";

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL, "postgres", "");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

