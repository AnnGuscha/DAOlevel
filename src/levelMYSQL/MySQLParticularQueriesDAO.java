package levelMYSQL;

import ExtendedEntity.CourseExtend;
import Manager.ConnectionPool;
import levelDAO.ParticularQueriesDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 12/18/2015.
 */
public class MySQLParticularQueriesDAO implements ParticularQueriesDAO {

    private static final Logger log = Logger.getLogger(MySQLParticularQueriesDAO.class);

    public List<CourseExtend> getCoursesForStudent(int idStudent) {
        List<CourseExtend> entites = new ArrayList<CourseExtend>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            PreparedStatement statement = connection.prepareStatement(getQueryCoursesForStudent());
            statement.setInt(1, idStudent);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CourseExtend courseExtend = getCourseExtend(rs);
                courseExtend.setMark(rs.getString("Mark"));
                entites.add(courseExtend);
            }
            log.info("Find " + entites.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }

    private String getQueryCoursesForStudent() {
        return "SELECT course.idCourse, course.Name, course.idProfessor,course.Description," +
                " professor.SurName, professor.Name as ProfessorName, professor.Patronymic, mark.Comment as Mark" +
                " FROM liststudents" +
                " JOIN course ON (liststudents.idCourse=course.idCourse)" +
                " JOIN Professor ON (Course.idProfessor = Professor.idProfessor)" +
                " LEFT OUTER JOIN mark ON (course.idCourse=mark.idCourse and liststudents.idStudent = mark.idStudent)" +
                " where liststudents.idStudent=?";
    }

    private CourseExtend getCourseExtend(ResultSet rs) throws SQLException {
        CourseExtend courseExtend = new CourseExtend();
        courseExtend.setId(rs.getInt("idCourse"));
        courseExtend.setName(rs.getString("Name"));
        courseExtend.setIdProfessor(rs.getInt("idProfessor"));
        courseExtend.setDescription(rs.getString("Description"));
        String nameProfessor = rs.getString("SurName") + " " + rs.getString("ProfessorName") + " " + rs.getString("Patronymic");
        courseExtend.setNameProfessor(nameProfessor);
        return courseExtend;
    }

    public List<CourseExtend> getCourses(int idStudent) {
        List<CourseExtend> entites = new ArrayList<CourseExtend>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            PreparedStatement statement = connection.prepareStatement(getQueryCourses());
            statement.setInt(1, idStudent);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CourseExtend courseExtend = getCourseExtend(rs);
                boolean isSubs = rs.getString("isSubs") != null ? true : false;
                courseExtend.setIsSubscription(isSubs);
                entites.add(courseExtend);
            }
            log.info("Find " + entites.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }

    private String getQueryCourses() {
        return "SELECT course.idCourse, course.Name, course.idProfessor,course.Description, " +
                "professor.SurName, professor.Name as ProfessorName, professor.Patronymic, liststudents.idListStudents as isSubs " +
                "FROM course " +
                "JOIN professor ON (Course.idProfessor = Professor.idProfessor) " +
                "left  OUTER JOIN liststudents ON (course.idCourse=liststudents.idCourse And idStudent=?)";
    }
}
