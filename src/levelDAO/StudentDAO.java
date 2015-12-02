package levelDAO;

import Entity.Student;

/**
 * Created by Anna on 12/1/2015.
 */
public interface StudentDAO {

    public int insertStudent(Student student);
    public boolean deleteStudent(int id);
    public Student findStudent(int id);
    public boolean updateStudent(Student newStudent);
    //public RowSet selectStudentRS();
    //public Collection selectStudentsTO();
}