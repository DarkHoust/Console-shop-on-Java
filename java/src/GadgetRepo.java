import java.sql.*;
import java.util.LinkedList;
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

    public Gadgets getGadget(int id){
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,brand,model,amount FROM electronics WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            if(rs.next()){
                Gadgets gadgets =  new Gadgets(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("amount"));
                return gadgets;
            }
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
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

        return null;
    }

    public List<Gadgets> getAllGadgets(){
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM electronics";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Gadgets> gadgets = new LinkedList<>();

            while (rs.next()){
                Gadgets gadgets1 = new Gadgets(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("amount"));
                gadgets.add(gadgets1);
            }
            return gadgets;
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
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }

        return null;
    }



}
