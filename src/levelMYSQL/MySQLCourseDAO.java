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
    PreparedStatement fillStatementParamsForSelect(Course entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getProfessorId());
        statement.setString(2, entity.getDescription());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(Course entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getProfessorId());
        statement.setString(2, entity.getDescription());
        statement.setInt(3, entity.getId());
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
