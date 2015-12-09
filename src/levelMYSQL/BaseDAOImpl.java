package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.IdEntity;
import Manager.ConnectionPool;
import Manager.ManagerMySqlQueries;
import levelDAO.BaseDAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAOImpl<T extends IdEntity> implements BaseDAO<T> {

    private static final Logger log = Logger.getLogger(BaseDAOImpl.class);

    public BaseDAOImpl() {
    }

    abstract PreparedStatement fillStatementParams(T entity, PreparedStatement statement) throws SQLException;

    abstract String getTypeParam();

    abstract T getT(ResultSet rs) throws SQLException;

    @Override
    public int insert(T entity) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".insert");//"INSERT INTO Course VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement = fillStatementParams(entity, statement);
            try {
                statement.execute();
                log.info("Insert record in database.");
                return 1;
            } catch (SQLException e1) {
                log.error("Error: ", e1);
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int count = statement.getUpdateCount();
            log.info("Delete from database " + count + " records.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public T find(int id) {
        T entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            entity = getT(rs);
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public boolean update(T entity) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".update");//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(query);
            log.info("Update in database " + count + " records.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<T> getAll() {
        List<T> entites = new ArrayList<T>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".select");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                entites.add(getT(rs));
            }
            log.info("Find " + entites.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }
}