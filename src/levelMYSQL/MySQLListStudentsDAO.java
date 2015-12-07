package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.ListStudents;
import levelDAO.ListStudentsDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLListStudentsDAO extends BaseDAOImpl<ListStudents> implements ListStudentsDAO {

    private static final Logger log = Logger.getLogger(MySQLListStudentsDAO.class);

    public MySQLListStudentsDAO() {
    }

    @Override
    PreparedStatement fillStatementParams(ListStudents entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setInt(2, entity.getIdCourse());
        statement.setInt(3, entity.getIdStudent());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "ListStudents";
    }

    @Override
    ListStudents getT(ResultSet rs) throws SQLException {
        return new ListStudents(rs.getInt("idlistStudent"), rs.getInt("idCourse"), rs.getInt("idStudent"));
    }
}

