package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class ListStudents extends IdEntity implements java.io.Serializable {

    private int idCourse;
    private int idStudent;

    public ListStudents() {
    }

    public ListStudents(int idCourse, int idStudent) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    public ListStudents(int id, int idCourse, int idStudent) {
        super(id);
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}