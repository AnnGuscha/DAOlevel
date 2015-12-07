package levelMYSQL;

import Entity.Student;
import levelDAO.StudentDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12/1/2015.
 */
public class MySQLStudentDAO extends BaseDAOImpl<Student> implements StudentDAO {

    private static final Logger log = Logger.getLogger(MySQLStudentDAO.class);

    public MySQLStudentDAO() {
    }

    @Override
    PreparedStatement fillStatementParams(Student entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getSurName());
        statement.setString(4, entity.getPatronymicName());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Student";
    }

    @Override
    Student getT(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("idStudent"), rs.getString("Name"), rs.getString("SurName"), rs.getString("Patronymic"));
    }
}