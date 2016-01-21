package levelMYSQL;

import Entity.Student;
import Manager.ConnectionPool;
import Manager.ManagerMySqlQueries;
import levelDAO.StudentDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public class MySQLStudentDAO extends BaseDAOImpl<Student> implements StudentDAO {

    private static final Logger log = Logger.getLogger(MySQLStudentDAO.class);

    public MySQLStudentDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(Student entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getSurName());
        statement.setString(3, entity.getPatronymicName());
        statement.setInt(4, entity.getUserId());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(Student entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getSurName());
        statement.setString(3, entity.getPatronymicName());
        statement.setInt(4, entity.getUserId());
        statement.setInt(5, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Student";
    }

    @Override
    Student getT(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("Id"), rs.getString("Name"), rs.getString("SurName"), rs.getString("Patronymic"), rs.getInt("UserId"));
    }

    @Override
    public List<Student> find(String name) {
        List<Student> entites = new ArrayList<Student>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".findByName");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                entites.add(getT(rs));
            }
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }

    @Override
    public Student findByUserId(int userId) {
        Student entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".findByUserId");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                entity = getT(rs);
                log.info("Find record in database.");
            } else
                log.info("Not find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entity;
    }
}