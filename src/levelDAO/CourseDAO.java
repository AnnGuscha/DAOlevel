package levelDAO;

import Entity.Course;
import ExtendedEntity.CourseExtend;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface CourseDAO extends BaseDAO<Course>{
    List<CourseExtend> getCourseExtentdList();
}