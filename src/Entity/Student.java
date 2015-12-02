package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Student implements java.io.Serializable {

    int id;
    String name;
    String surName;
    String patronymicName;

    public Student (int id, String name, String surName, String patronymicName)
    {
        this.id=id;
        this.name=name;
        this.surName=surName;
        this.patronymicName=patronymicName;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurName()
    {
        return surName;
    }

    public String getPatronymicName()
    {
        return patronymicName;
    }

    public String toString()
    {
        return getId()+" "+getName()+" "+getSurName()+" "+ getPatronymicName();
    }
}
