package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class ListStudents implements java.io.Serializable {
    int id;
    int idCourse;
    int idStudent;

    public ListStudents(int id, int idCourse, int idStudent)
    {
        this.id=id;
        this.idCourse=idCourse;
        this.idStudent=idStudent;
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
}