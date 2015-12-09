package levelDAO;

import Entity.Student;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface StudentDAO extends BaseDAO<Student> {
    List<Student> find(String name);
}