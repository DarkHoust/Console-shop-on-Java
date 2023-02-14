package control.interfaces;

public interface ControllerUser {
    String createUser(String login, String password);
    String checkUser(String login, String password);
}
