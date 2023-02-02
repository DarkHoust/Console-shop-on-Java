import java.sql.*;

public class ConnectionTest {
    public static void main(String[] args) {
        String connectionURL = "jdbc:postgresql://localhost:5432/Electronic";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        try{
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionURL, "postgres", "");

            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM electronics");

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Manufacturer: " + rs.getString("brand") + ", Model: " + rs.getString("model") + ", in stock - " + rs.getInt("amount"));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
