package levelMYSQL;

import Entity.User;
import Manager.ConnectionPool;
import Manager.ManagerMySqlQueries;
import levelDAO.UserDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna on 12/21/2015.
 */
public class MySQLUserDAO extends BaseDAOImpl<User> implements UserDAO {

    private static final Logger log = Logger.getLogger(MySQLUserDAO.class);

    public MySQLUserDAO() {
    }

    @Override
    PreparedStatement fillStatementParamsForInsert(User entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
        statement.setInt(3, entity.getRole());
        return statement;
    }

    @Override
    PreparedStatement fillStatementParamsForUpdate(User entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getLogin());
        statement.setString(2, entity.getPassword());
        statement.setInt(3, entity.getRole());
        statement.setInt(4, entity.getId());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "User";
    }

    @Override
    User getT(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("Login"), rs.getString("Password"), rs.getInt("Role"));
    }


    @Override
    public User find(String login, String pwd) {
        User entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".findByLoginAndPwd");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, pwd);
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

    @Override
    public User find(String login) {
        User entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".findByLogin");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                entity = getT(rs);
                log.info("Find record in database.");
            } else
                log.info("Not find record in database.");
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entity;
    }
}
