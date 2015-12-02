package levelDAO;

import Entity.Course;

/**
 * Created by Anna on 12/1/2015.
 */
public interface CourseDAO {

    boolean insertCourse(Course course);
    boolean deleteCourse(int id);
    Course findCourse(int id);
    boolean updateCourse(Course newCourse);
    //public RowSet selectCourseRS();
    //public Collection selectCoursesTO();
}