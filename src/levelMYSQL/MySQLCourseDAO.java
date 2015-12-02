package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.Course;
import Manager.*;
import levelDAO.CourseDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class MySQLCourseDAO implements CourseDAO {

    private static final Logger log = Logger.getLogger(MySQLCourseDAO.class);

    public MySQLCourseDAO()
    {
    }

    public boolean insertCourse(Course course) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("curses.insert");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,course.getId());
            statement.setInt(2,course.getProfessorId());
            statement.setString(3,course.getDescription());
            if(statement.execute())
            {
                log.info("Insert course in database ");
                return true;
            }
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("curses.delete");//"DELETE FROM Course WHERE idCourse=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int count=statement.getUpdateCount();
            log.info("Delete from database " + count + " courses");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

    public Course findCourse(int id) {
        Course course=null;
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("curses.find");//"SELECT * FROM Course WHERE idCourse = "+id;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery(query);
            course = new Course(rs.getInt("idCourse"),rs.getInt("idProfessor"),rs.getString("Description"));
            log.info("Find course in database");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return course;
    }

    public boolean updateCourse(Course newCourse) {
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query= ManagerMySqlQueries.getInstance().getObject("curses.update");//"UPDATE Course SET idCourse="+id;
            Statement statement = connection.createStatement();
            int count=statement.executeUpdate(query);
            log.info("Update in database " + count + " courses");
        } catch (SQLException e) {
            log.error("Error: ",e);
            e.printStackTrace();
        }
        return false;
    }

}
