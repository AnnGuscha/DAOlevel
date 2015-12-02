package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */
import Entity.Mark;
import Manager.*;
import levelDAO.MarkDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class MySQLMarkDAO implements MarkDAO {

    private static final Logger log = Logger.getLogger(MySQLMarkDAO.class);


    public MySQLMarkDAO()
    {
    }

    public int insertMark(Mark mark) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("insert");//"INSERT INTO Mark VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,mark.getId());
            statement.setInt(2,mark.getIdCourse());
            statement.setInt(3,mark.getIdStudent());
            statement.setString(4,mark.getComment());
            if(statement.execute())
            {
                log.info("Insert mark in database ");
                return 1;
            }
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteMark(int id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int count=statement.getUpdateCount();
            log.info("Delete from database " + count + " marks");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

    public Mark findMark(int id) {
        Mark mark=null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery(query);
            mark = new Mark(rs.getInt("idMark"),rs.getInt("idCourses"),rs.getInt("isStudent"),rs.getString("Comment"));
            log.info("Find mark in database");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return mark;
    }

    public boolean updateMark(Mark newMark) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("update");//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count=statement.executeUpdate(query);
            log.info("Update in database " + count + " marks");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

}