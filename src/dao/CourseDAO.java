package dao;

import entity.Course;
import entity.extended.CourseExtend;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface CourseDAO extends BaseDAO<Course>{

    List<CourseExtend> getCourseExtentdList();

    Course getCourseByProfessor(int idProfessor);
}