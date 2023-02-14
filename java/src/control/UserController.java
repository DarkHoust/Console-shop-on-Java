package control;

import control.interfaces.ControllerUser;
import entity.User;
import user_info.interfaces.IUserRepo;

public class UserController implements ControllerUser {
    private IUserRepo repo;

    public UserController(IUserRepo repo){
        this.repo = repo;
    }

    public String createUser(String login, String password){
        User user = new User(login,password);

        boolean isCreated = repo.createUser(user);

        return (isCreated ? "Congratulation! User has been registered!" : "Something went wrong");
    }

    public boolean checkUser(String login, String password){
        return repo.checkUser(login,password);
    }
}
