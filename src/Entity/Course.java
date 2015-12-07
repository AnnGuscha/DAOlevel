package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Course extends IdEntity implements java.io.Serializable {

    int professorId;
    String description;

    public Course(int id, int professorId, String description) {
        super(id);
        this.professorId = professorId;
        this.description = description;
    }

    public int getProfessorId() {
        return professorId;
    }

    public String getDescription() {
        return description;
    }
}


