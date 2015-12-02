package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */
import Entity.Professor;
import Manager.*;
import levelDAO.ProfessorDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class MySQLProfessorDAO implements ProfessorDAO {

    private static final Logger log = Logger.getLogger(MySQLProfessorDAO.class);

    public MySQLProfessorDAO() {
    }

    public int insertProfessor(Professor professor) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("professor.insert");//"INSERT INTO Course VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,professor.getId());
            statement.setString(2,professor.getFirstName());
            statement.setString(3,professor.getSurName());
            statement.setString(4,professor.getPatronymicName());
            if(statement.execute())
            {
                log.info("Insert record about professor in database ");
                return 1;
            }
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteProfessor(int id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("professor.delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int count=statement.getUpdateCount();
            log.info("Delete from database " + count + " record about professors");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

    public Professor findProfessor(int id) {
        Professor professor=null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("professor.find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            professor = new Professor(rs.getInt("idProfessor"),rs.getString("Name"),rs.getString("SurName"),rs.getString("Patronymic"));
            log.info("Find record about professor in database");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return professor;
    }

    public boolean updateProfessor(Professor newProfessor) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("professor.update");;//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count=statement.executeUpdate(query);
            log.info("Update in database " + count + " record about professors");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

}

