package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Student extends IdEntity implements java.io.Serializable {

    String name;
    String surName;
    String patronymicName;

    public Student(int id, String name, String surName, String patronymicName) {
        super(id);
        this.name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String toString() {
        return super.getId() + " " + getName() + " " + getSurName() + " " + getPatronymicName();
    }
}
