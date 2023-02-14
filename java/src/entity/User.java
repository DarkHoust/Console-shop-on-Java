package entity;

public class User {
    private int id;
    private String login;
    private String password;

    public User(){
    };

    public User(int id, String login, String password){
        setId(id);
        setLogin(login);
        setPassword(password);
    }

    public User(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "id: " + id + ", login: " + login + ", password: " + password;
    }
}
