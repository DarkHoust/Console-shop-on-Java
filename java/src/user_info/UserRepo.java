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
            String sqlQuery = "SELECT login,passwords FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            List<User> users = new LinkedList<>();

            while (rs.next()){
                User user1 = new User(rs.getString("login"), rs.getString("passwords"));
                users.add(user1);
            }

            boolean isUserExist = false;
            for(User user : users){
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    isUserExist = true;
                    break;
                }
            }

            return isUserExist;

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
            String sqlQuery = "INSERT INTO users(login,passwords) VALUES (?,?)";
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
