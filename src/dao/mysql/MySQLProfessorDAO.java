package dao.mysql;

/**
 * Created by Anna on 12/1/2015.
 */

import dao.ProfessorDAO;
import entity.Professor;
import manager.ConnectionPool;
import manager.ManagerMySqlQueries;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLProfessorDAO extends BaseDAOImpl<Professor> implements ProfessorDAO {

    private static final Logger log = Logger.getLogger(MySQLProfessorDAO.class);

    public MySQLProfessorDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(Professor entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getSurName());
        statement.setString(3, entity.getPatronymicName());
        statement.setInt(4, entity.getUserId());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(Professor entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getSurName());
        statement.setString(3, entity.getPatronymicName());
        statement.setInt(4, entity.getUserId());
        statement.setInt(5, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Professor";
    }

    @Override
    Professor getT(ResultSet rs) throws SQLException {
        return new Professor(rs.getInt("Id"), rs.getString("Name"), rs.getString("SurName"), rs.getString("Patronymic"), rs.getInt("UserId"));
    }

    @Override
    public Professor findByUserId(int userId) {
        Professor entity = null;
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

