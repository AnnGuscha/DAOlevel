package dao;

import entity.extended.CourseExtend;
import entity.extended.MarkExtend;
import entity.extended.StudentExtend;

import java.util.List;

/**
 * Created by Anna on 12/18/2015.
 */
public interface ParticularQueriesDAO {

    List<CourseExtend> getCoursesForStudent(int idStudent) throws DAOException;

    List<CourseExtend> getCourses(int idStudent) throws DAOException;

    List<StudentExtend> getStudentsByCourse(int idCourse) throws DAOException;

    List<StudentExtend> getStudentsByProfessor(int idProfessor) throws DAOException;

    MarkExtend find(int idCourse, int idStudent) throws DAOException;
}
