package dao.mysql;

/**
 * Created by Anna on 12/1/2015.
 */

import dao.BaseDAO;
import dao.DAOException;
import entity.IdEntity;
import manager.ConnectionPool;
import manager.ManagerMySqlQueries;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAOImpl<T extends IdEntity> implements BaseDAO<T> {

    private static final Logger log = Logger.getLogger(BaseDAOImpl.class);

    public BaseDAOImpl() {
    }

    abstract PreparedStatement fillStatementParamsForInsert(T entity, PreparedStatement statement) throws SQLException;

    abstract PreparedStatement fillStatementParamsForUpdate(T entity, PreparedStatement statement) throws SQLException;

    abstract String getTypeParam();

    abstract T getT(ResultSet rs) throws SQLException;

    @Override
    public int insert(T entity) throws DAOException {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".insert");
            PreparedStatement statement = connection.prepareStatement(query);
            statement = fillStatementParamsForInsert(entity, statement);

            statement.execute();
            log.info("Insert record in database.");
            return 1;
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not insert record ", e);
        } finally {
            return 0;
        }
    }

    @Override
    public boolean delete(int id) throws DAOException {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".delete");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            log.info("Delete from database " + count + " records.");
            return true;
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not delete record ", e);
        } finally {
            return false;
        }
    }

    @Override
    public T find(int id) throws DAOException {
        T entity = null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".find");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                entity = getT(rs);
                log.info("Find record in database with id = " + id);
            } else
                log.info("Not find record in database with id = " + id);
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        }
        return entity;
    }

    @Override
    public boolean update(T entity) throws DAOException {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".update");
            PreparedStatement statement = connection.prepareStatement(query);
            statement = fillStatementParamsForUpdate(entity, statement);
            int count = statement.executeUpdate();
            log.info("Update in database " + count + " records.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not update record ", e);
        }
        return false;
    }

    @Override
    public List<T> getAll() throws DAOException {
        String query = ManagerMySqlQueries.getInstance().getObject(getTypeParam() + ".select");
        List<T> entities = getList(query);
        return entities;
    }

    protected List<T> getList(String query) throws DAOException {
        List<T> entities = new ArrayList<T>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                entities.add(getT(rs));
            }
            log.info("Find " + entities.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
            throw new DAOException("Can not find record ", e);
        }
        return entities;
    }
}