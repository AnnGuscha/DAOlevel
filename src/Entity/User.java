package Entity;


/**
 * Created by Anna on 12/21/2015.
 */
public class User extends IdEntity {

    private String login;
    private String password;
    private int role;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = 0;
    }

    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String login, String password, int role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
