package dao.mysql;

/**
 * Created by Anna on 12/1/2015.
 */

import dao.DAOException;
import dao.MarkDAO;
import entity.Mark;
import manager.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLMarkDAO extends BaseDAOImpl<Mark> implements MarkDAO {

    private static final Logger log = Logger.getLogger(MySQLMarkDAO.class);


    public MySQLMarkDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(Mark entity, PreparedStatement statement) throws SQLException {
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
        return new Mark(rs.getInt("idMark"), rs.getInt("idCourse"), rs.getInt("idStudent"), rs.getString("Comment"));
    }

    public Mark find(int idCourse, int idStudent) throws DAOException {
        Mark entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = "select * from mark where mark.idCourse = ? and mark.idStudent = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCourse);
            statement.setInt(2, idStudent);
            ResultSet rs = statement.executeQuery();
            rs.next();
            entity = getT(rs);
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        }
        return entity;
    }

    public boolean delete(Mark mark) throws DAOException {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = "delete from mark where mark.idCourse=? and mark.idStudent=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, mark.getIdCourse());
            statement.setInt(2, mark.getIdStudent());
            int count = statement.executeUpdate();
            log.info("Delete from database " + count + " records.");
            return true;
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        } finally {
            return false;
        }
    }
}