package dao.mysql;

/**
 * Created by Anna on 12/1/2015.
 */

import dao.DAOException;
import dao.ListStudentsDAO;
import entity.ListStudents;
import manager.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLListStudentsDAO extends BaseDAOImpl<ListStudents> implements ListStudentsDAO {

    private static final Logger log = Logger.getLogger(MySQLListStudentsDAO.class);

    public MySQLListStudentsDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(ListStudents entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getIdCourse());
        statement.setInt(2, entity.getIdStudent());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(ListStudents entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getIdCourse());
        statement.setInt(2, entity.getIdStudent());
        statement.setInt(3, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "ListStudents";
    }

    @Override
    ListStudents getT(ResultSet rs) throws SQLException {
        return new ListStudents(rs.getInt("idListStudents"), rs.getInt("idCourse"), rs.getInt("idStudent"));
    }

    public boolean delete(ListStudents listStudents) throws DAOException {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = getQueryDelete();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, listStudents.getIdCourse());
            statement.setInt(2, listStudents.getIdStudent());
            int count = statement.executeUpdate();
            log.info("Delete from database " + count + " records.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not delete record ", e);
        }
        return false;
    }

    private String getQueryDelete() {
        return "DELETE FROM ListStudents WHERE idCourse=? AND idStudent=?";
    }
}

