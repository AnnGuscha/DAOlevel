package dao.mysql;

/**
 * Created by Anna on 12/1/2015.
 */

import dao.CourseDAO;
import dao.DAOException;
import entity.Course;
import entity.extended.CourseExtend;
import manager.ConnectionPool;
import manager.ManagerMySqlQueries;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCourseDAO extends BaseDAOImpl<Course> implements CourseDAO {

    private static final Logger log = Logger.getLogger(MySQLCourseDAO.class);

    public MySQLCourseDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(Course entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getIdProfessor());
        statement.setString(3, entity.getDescription());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(Course entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getIdProfessor());
        statement.setString(3, entity.getDescription());
        statement.setInt(4, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Course";
    }

    @Override
    Course getT(ResultSet rs) throws SQLException {
        return new Course(rs.getInt("idCourse"), rs.getString("Name"), rs.getInt("idProfessor"), rs.getString("Description"));
    }

    public List<CourseExtend> getCourseExtentdList() throws DAOException {
        List<CourseExtend> entities = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".selectJoin");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                entities.add(new CourseExtend(rs.getInt("idCourse"), rs.getString("Name"), rs.getInt("idProfessor"), rs.getString("Description"), rs.getString("SurName") + " " + rs.getString("Name") + " " + rs.getString("Patronymic")));
            }
            log.info("Find " + entities.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        }
        return entities;
    }

    public Course getCourseByProfessor(int idProfessor) throws DAOException {
        Course entity = new Course();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".findByProfessor");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idProfessor);
            ResultSet rs = statement.executeQuery();
            rs.next();
            entity.setId(rs.getInt("idCourse"));
            entity.setName(rs.getString("Name"));
            entity.setDescription(rs.getString("Description"));
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        }
        return entity;
    }
}
