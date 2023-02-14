package control.interfaces;

public interface ControllerUser {
    String createUser(String login, String password);
    boolean checkUser(String login, String password);
}
