package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class ListStudents extends IdEntity implements java.io.Serializable {
    int idCourse;
    int idStudent;

    public ListStudents(int id, int idCourse, int idStudent) {
        super(id);
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public int getIdStudent() {
        return idStudent;
    }
}