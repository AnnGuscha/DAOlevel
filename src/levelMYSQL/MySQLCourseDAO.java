package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.Course;
import levelDAO.CourseDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
