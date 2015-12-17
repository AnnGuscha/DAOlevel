package ExtendedEntity;

import Entity.Course;

/**
 * Created by Anna on 12/17/2015.
 */
public class CourseExtend extends Course {

    private String nameProfessor;

    public CourseExtend() {
    }

    public CourseExtend(String name, int idProfessor, String description, String nameProfessor) {
        super(name, idProfessor, description);
        this.nameProfessor = nameProfessor;
    }

    public CourseExtend(int id, String name, int idProfessor, String description, String nameProfessor) {
        super(id, name, idProfessor, description);
        this.nameProfessor = nameProfessor;
    }

    public String getNameProfessor() {
        return nameProfessor;
    }

    public void setNameProfessor(String nameProfessor) {
        this.nameProfessor = nameProfessor;
    }
}
