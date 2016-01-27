package entity;

/**
 * Created by Anna on 12/1/2015.
 */
public class Course extends IdEntity implements java.io.Serializable {

    private String name;
    private int idProfessor;
    private String description;

    public Course() {
    }

    public Course(String name, int idProfessor, String description) {
        this.name = name;
        this.idProfessor = idProfessor;
        this.description = description;
    }

    public Course(int id, String name, int idProfessor, String description) {
        super(id);
        this.name = name;
        this.idProfessor = idProfessor;
        this.description = description;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
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


