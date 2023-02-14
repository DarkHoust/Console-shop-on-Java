package user_info.interfaces;

import entity.User;

public interface IUserRepo {
    boolean checkUser(String login, String password);
    boolean createUser(User user);
}
