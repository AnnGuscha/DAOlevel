package entity.extended;

import entity.Course;

/**
 * Created by Anna on 12/17/2015.
 */
public class CourseExtend extends Course {

    private String nameProfessor;
    private String mark;
    private boolean isSubscription;

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean getIsSubscription() {
        return isSubscription;
    }

    public void setIsSubscription(boolean isSubscription) {
        this.isSubscription = isSubscription;
    }
}
