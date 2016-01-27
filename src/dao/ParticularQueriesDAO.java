package dao;

import entity.extended.CourseExtend;
import entity.extended.MarkExtend;
import entity.extended.StudentExtend;

import java.util.List;

/**
 * Created by Anna on 12/18/2015.
 */
public interface ParticularQueriesDAO {

    List<CourseExtend> getCoursesForStudent(int idStudent);

    List<CourseExtend> getCourses(int idStudent);

    List<StudentExtend> getStudentsByCourse(int idCourse);

    List<StudentExtend> getStudentsByProfessor(int idProfessor);

    MarkExtend find(int idCourse, int idStudent);
}
