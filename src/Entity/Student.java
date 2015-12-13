package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Student extends IdEntity implements java.io.Serializable {

    private String name;
    private String surName;
    private String patronymicName;

    public Student() {
        super();
    }

    public Student(String name, String surName, String patronymicName) {
        this.name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
    }

    public Student(int id, String name, String surName, String patronymicName) {
        super(id);
        this.name = name;
        this.surName = surName;
        this.patronymicName = patronymicName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return super.getId() + " " + getName() + " " + getSurName() + " " + getPatronymicName();
    }
}
