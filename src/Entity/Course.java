package Entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Course extends IdEntity implements java.io.Serializable {

    private String name;
    private int professorId;
    private String description;

    public Course() {
    }

    public Course(String name, int professorId, String description) {
        this.name = name;
        this.professorId = professorId;
        this.description = description;
    }

    public Course(int id, String name, int professorId, String description) {
        super(id);
        this.name = name;
        this.professorId = professorId;
        this.description = description;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


