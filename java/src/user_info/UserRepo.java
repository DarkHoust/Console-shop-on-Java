package user_info;

import entity.User;
import sql_query.DB;
import user_info.interfaces.IUserRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepo implements IUserRepo {

    private DB db;

    public UserRepo(DB db){
        this.db = db;
    }

    public boolean checkUser(String login, String password){
        Connection con = null;

        try {
            con = db.getConnection();
            String sqlQuery = "SELECT login,password FROM user";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            List<User> users = new LinkedList<>();

            while (rs.next()){
                User user1 = new User(rs.getString("login"), rs.getString("password"));
                users.add(user1);
            }

            for(User user : users){
                if(user.getLogin() != login || user.getPassword() != password){
                    return false;
                }
            }

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
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return true;
    }

    public boolean createUser(User user){
        Connection con = null;

        try {
            con = db.getConnection();
            String sqlQuery = "INSERT INTO user(login,password) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sqlQuery);

            st.setString(1,user.getLogin());
            st.setString(2, user.getPassword());

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
