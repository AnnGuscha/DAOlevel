package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.Mark;
import levelDAO.MarkDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLMarkDAO extends BaseDAOImpl<Mark> implements MarkDAO {

    private static final Logger log = Logger.getLogger(MySQLMarkDAO.class);


    public MySQLMarkDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForSelect(Mark entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getIdCourse());
        statement.setInt(2, entity.getIdStudent());
        statement.setString(3, entity.getComment());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(Mark entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getIdCourse());
        statement.setInt(2, entity.getIdStudent());
        statement.setString(3, entity.getComment());
        statement.setInt(4, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Mark";
    }

    @Override
    Mark getT(ResultSet rs) throws SQLException {
        return new Mark(rs.getInt("idMark"), rs.getInt("idCourses"), rs.getInt("isStudent"), rs.getString("Comment"));
    }
}