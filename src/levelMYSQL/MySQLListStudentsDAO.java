package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */
import Entity.ListStudents;
import Manager.*;
import levelDAO.ListStudentsDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class MySQLListStudentsDAO implements ListStudentsDAO {

    private static final Logger log = Logger.getLogger(MySQLListStudentsDAO.class);

    public MySQLListStudentsDAO()
    {
    }

    public int insertListStudents(ListStudents listStudents) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("listStudents.insert");//"INSERT INTO Course VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,listStudents.getId());
            statement.setInt(2,listStudents.getIdCourse());
            statement.setInt(3,listStudents.getIdStudent());
            if(statement.execute())
            {
                log.info("Insert listStudents in database ");
                return 1;
            }
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteListStudents(int id) {
        try{
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("listStudents.delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int count=statement.getUpdateCount();
            log.info("Delete from database " + count + " listStudents");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

    public ListStudents findListStudents(int id) {
        ListStudents listStudents=null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("listStudents.find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery(query);
            listStudents = new ListStudents(rs.getInt("idlistStudent"),rs.getInt("idCourse"),rs.getInt("idStudent"));
            log.info("Find listStudents in database");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateListStudents(ListStudents newListStudents) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("listStudents.update");;//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count=statement.executeUpdate(query);
            log.info("Update in database " + count + " listStudents");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

}

