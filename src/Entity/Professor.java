package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Professor extends IdEntity implements java.io.Serializable {

    private String firstName;
    private String surName;
    private String patronymicName;
    private int userId;

    public Professor() {
    }

    public Professor(String firstName, String surName, String patronymicName, int userId) {
        this.firstName = firstName;
        this.surName = surName;
        this.patronymicName = patronymicName;
        this.userId = userId;
    }

    public Professor(int id, String firstName, String surName, String patronymicName, int userId) {
        super(id);
        this.firstName = firstName;
        this.surName = surName;
        this.patronymicName = patronymicName;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String toString() {
        return getId() + " " + getFirstName() + " " + getSurName() + " " + getPatronymicName();
    }
}

