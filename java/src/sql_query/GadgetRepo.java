package sql_query;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import entity.Gadgets;
import sql_query.interfaces.IGadgetRepo;

public class GadgetRepo implements IGadgetRepo {
    private DB db;

    public GadgetRepo(DB db){
        this.db = db;
    }

    public boolean createGadget(Gadgets gadgets){ //to sell
        Connection con = null;

        try {
            con = db.getConnection();
            String sqlQuery = "INSERT INTO electronics(amount, brand, model) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sqlQuery);

            st.setInt(1,gadgets.getAmount());
            st.setString(2, gadgets.getBrand());
            st.setString(3,gadgets.getModel());
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

    public Gadgets getGadget(int id){ // to get info by id
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,amount,brand,model FROM electronics WHERE id=? ORDER BY id";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            if(rs.next()){
                Gadgets gadgets =  new Gadgets(rs.getInt("id"),
                                               rs.getInt("amount"),
                                               rs.getString("brand"),
                                               rs.getString("model"));
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

    public List<Gadgets> getAllGadgets(){ // to get info about all gadgets
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,amount,brand,model FROM electronics ORDER BY id";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Gadgets> gadgets = new LinkedList<>();

            while (rs.next()){
                Gadgets gadgets1 = new Gadgets(rs.getInt("id"),rs.getInt("amount"), rs.getString("brand"), rs.getString("model"));
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

    public String UpdateAmount(int id, int amount){
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "UPDATE electronics SET amount = amount - ? WHERE ID = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,amount);
            stmt.setInt(2,id);
            stmt.executeUpdate();
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
                return "Informtaion has been updated!";
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return "Information has been updated!";
    }

    public boolean isAvailable(int id){
        Connection con = null;

        try {
            con = db.getConnection();

            String sql = "SELECT amount FROM electronics WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                if (rs.getInt("amount") <= 0) {
                    return false;
                }
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
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }
}
