package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Mark implements java.io.Serializable {
    int id;
    int idCourse;
    int idStudent;
    String comment;

    public Mark(int id, int idCourse, int idStudent, String comment)
    {
        this.id=id;
        this.idCourse=idCourse;
        this.idStudent=idStudent;
        this.comment=comment;
    }

    public int getId()
    {
        return id;
    }

    public int getIdCourse()
    {
        return idCourse;
    }

    public int getIdStudent()
    {
        return idStudent;
    }

    public String getComment()
    {
        return comment;
    }
}
