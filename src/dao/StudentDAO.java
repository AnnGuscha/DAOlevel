package dao;

import entity.Student;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface StudentDAO extends BaseDAO<Student> {
    List<Student> find(String name);

    Student findByUserId(int userId);
}