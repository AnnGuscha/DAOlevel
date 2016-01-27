package entity.extended;

import entity.Mark;

/**
 * Created by Anna on 12/19/2015.
 */
public class MarkExtend extends Mark {

    String nameCourse;
    String nameStudent;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
}
