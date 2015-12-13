package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Mark extends IdEntity implements java.io.Serializable {

    private int idCourse;
    private int idStudent;
    private String comment;

    public Mark() {
    }

    public Mark(int idCourse, int idStudent, String comment) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.comment = comment;
    }

    public Mark(int id, int idCourse, int idStudent, String comment) {
        super(id);
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
