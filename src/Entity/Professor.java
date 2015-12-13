package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Professor extends IdEntity implements java.io.Serializable {

    private String firstName;
    private String surName;
    private String patronymicName;

    public Professor() {
    }

    public Professor(String firstName, String surName, String patronymicName) {
        this.firstName = firstName;
        this.surName = surName;
        this.patronymicName = patronymicName;
    }

    public Professor(int id, String firstName, String surName, String patronymicName) {
        super(id);
        this.firstName = firstName;
        this.surName = surName;
        this.patronymicName = patronymicName;
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

