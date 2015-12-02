package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Professor implements java.io.Serializable {

    int id;
    String firstName;
    String surName;
    String patronymicName;

    public Professor(int id, String firstName, String surName, String patronymicName)
    {
        this.id=id;
        this.firstName=firstName;
        this.surName=surName;
        this.patronymicName=patronymicName;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
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
        return getId()+" "+getFirstName()+" "+getSurName()+" "+ getPatronymicName();
    }
}

