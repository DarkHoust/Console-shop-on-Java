import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GadgetRepo implements IGadgetRepo{
    private DB db;

    public GadgetRepo(DB db){
        this.db = db;
    }

    public boolean createGadget(Gadgets gadgets){
        Connection con = null;

        try {
            con = db.getConnection();
            String sqlQuery = "INSERT INTO electronics(brand, model, amount) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sqlQuery);

            st.setString(1, gadgets.getBrand());
            st.setString(2,gadgets.getModel());
            st.setInt(3,gadgets.getAmount());

            st.execute();
            return true;
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    




}







}
