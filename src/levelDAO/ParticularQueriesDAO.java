package levelDAO;

import ExtendedEntity.CourseExtend;

import java.util.List;

/**
 * Created by Anna on 12/18/2015.
 */
public interface ParticularQueriesDAO {

    List<CourseExtend> getCoursesForStudent(int idStudent);

    List<CourseExtend> getCourses(int idStudent);
}
