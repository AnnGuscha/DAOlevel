package levelDAO;

import Entity.Course;

/**
 * Created by Anna on 12/1/2015.
 */
public interface CourseDAO {

    public boolean insertCourse(Course course);
    public boolean deleteCourse(int id);
    public Course findCourse(int id);
    public boolean updateCourse(Course newCourse);
    //public RowSet selectCourseRS();
    //public Collection selectCoursesTO();
}