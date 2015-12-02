package levelDAO;

import Entity.Student;

/**
 * Created by Anna on 12/1/2015.
 */
public interface StudentDAO {

    int insertStudent(Student student);
    boolean deleteStudent(int id);
    Student findStudent(int id);
    boolean updateStudent(Student newStudent);
    //public RowSet selectStudentRS();
    //public Collection selectStudentsTO();
}