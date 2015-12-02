package levelMYSQL;

import Entity.Student;
import Manager.ConnectionPool;
import Manager.ManagerMySqlQueries;
import levelDAO.StudentDAO;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by Anna on 12/1/2015.
 */
public class MySQLStudentDAO implements StudentDAO {

    private static final Logger log = Logger.getLogger(MySQLStudentDAO.class);

    public MySQLStudentDAO() {
    }

    public int insertStudent(Student student) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("student.insert");//"INSERT INTO Course VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,student.getId());
            statement.setString(2,student.getName());
            statement.setString(3,student.getSurName());
            statement.setString(4,student.getPatronymicName());
            if(statement.execute())
            {
                log.info("Insert record about student in database ");
                return 1;
            }
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteStudent(int id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("student.delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int count=statement.getUpdateCount();
            log.info("Delete from database " + count + " record about students");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return true;
    }
    public Student findStudent(int id) {
        Student student=null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("student.find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery(query);
            student = new Student(rs.getInt("idStudent"),rs.getString("Name"),rs.getString("SurName"),rs.getString("Patronymic"));
            log.info("Find record about student in database");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return student;
    }
    public boolean updateStudent(Student newStudent) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("student.update");;//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count=statement.executeUpdate(query);
            log.info("Update in database " + count + " record about student");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return true;
    }
}