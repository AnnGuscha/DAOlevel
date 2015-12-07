package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Professor extends IdEntity implements java.io.Serializable {

    String firstName;
    String surName;
    String patronymicName;

    public Professor(int id, String firstName, String surName, String patronymicName) {
        super(id);
        this.firstName = firstName;
        this.surName = surName;
        this.patronymicName = patronymicName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String toString() {
        return getId() + " " + getFirstName() + " " + getSurName() + " " + getPatronymicName();
    }
}

