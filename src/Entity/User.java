package entity;

import manager.Locale;
import manager.Role;

/**
 * Created by Anna on 12/21/2015.
 */
public class User extends IdEntity {

    private String login;
    private String password;
    private int role;
    private String locale;

    public User() {
        super();
        this.role = Role.STUDENT.getValue();
        this.locale = Locale.DEFAULT.toString();
    }

    public User(String login, String password) {
        this();
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, int role) {
        this(login, password);
        this.role = role;
        this.locale = Locale.DEFAULT.toString();
    }

    public User(int id, String login, String password, int role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
        this.locale = Locale.DEFAULT.toString();
    }

    public User(String login, String password, int role, String locale) {
        this(login, password, role);
        this.locale = locale;
    }

    public User(int id, String login, String password, int role, String locale) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
        this.locale = locale;
    }

    public User(String login, String password, String locale) {
        this(login, password);
        this.locale = locale;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
