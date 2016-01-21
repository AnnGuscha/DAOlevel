package levelMYSQL;

import ExtendedEntity.CourseExtend;
import ExtendedEntity.MarkExtend;
import ExtendedEntity.StudentExtend;
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
                " JOIN Professor ON (Course.idProfessor = Professor.Id)" +
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
                "JOIN professor ON (Course.idProfessor = Professor.Id) " +
                "left  OUTER JOIN liststudents ON (course.idCourse=liststudents.idCourse And idStudent=?)";
    }

    public List<StudentExtend> getStudentsByCourse(int idCourse) {
        List<StudentExtend> entites = new ArrayList<StudentExtend>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            PreparedStatement statement = connection.prepareStatement(getQueryStudentsByCourse());
            statement.setInt(1, idCourse);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                StudentExtend studentExtend = getStudentExtend(rs);
                entites.add(studentExtend);
            }
            log.info("Find " + entites.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }

    private StudentExtend getStudentExtend(ResultSet rs) throws SQLException {
        StudentExtend studentExtend = new StudentExtend();
        studentExtend.setId(rs.getInt("Id"));
        studentExtend.setName(rs.getString("Name"));
        studentExtend.setSurName(rs.getString("SurName"));
        studentExtend.setPatronymicName(rs.getString("Patronymic"));
        studentExtend.setMark(rs.getString("Mark"));
        return studentExtend;
    }

    private String getQueryStudentsByCourse() {
        return "SELECT \n" +
                "    student.Id,\n" +
                "    student.Name,\n" +
                "    student.SurName,\n" +
                "    student.Patronymic,\n" +
                "    mark.Comment AS Mark\n" +
                "FROM\n" +
                "    liststudents\n" +
                "        JOIN\n" +
                "    student ON (liststudents.idStudent = student.Id AND liststudents.idCourse=?)\n" +
                "        LEFT OUTER JOIN\n" +
                "    mark ON (student.Id = mark.idStudent\n" +
                "        AND liststudents.idCourse = mark.idCourse)";
    }

    public List<StudentExtend> getStudentsByProfessor(int idProfessor) {
        List<StudentExtend> entites = new ArrayList<StudentExtend>();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            PreparedStatement statement = connection.prepareStatement(getQueryStudentsByProfessor());
            statement.setInt(1, idProfessor);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                StudentExtend studentExtend = getStudentExtend(rs);
                entites.add(studentExtend);
            }
            log.info("Find " + entites.size() + " records in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entites;
    }

    private String getQueryStudentsByProfessor() {
        return "SELECT \n" +
                "    student.Id,\n" +
                "    student.Name,\n" +
                "    student.SurName,\n" +
                "    student.Patronymic,\n" +
                "    mark.Comment AS Mark\n" +
                "FROM\n" +
                "    liststudents\n" +
                "        JOIN\n" +
                "    student ON (liststudents.idStudent = student.Id " +
                "        AND liststudents.idCourse=(select course.idCourse from course where course.idProfessor = ? limit 1))\n" +
                "        LEFT OUTER JOIN\n" +
                "    mark ON (student.Id = mark.idStudent\n" +
                "        AND liststudents.idCourse = mark.idCourse)";
    }

    public MarkExtend find(int idCourse, int idStudent) {
        MarkExtend entity = new MarkExtend();
        try {
            Connection connection = ConnectionPool.getConnectionPool().retrieve();
            String query = getQueryMark();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCourse);
            statement.setInt(2, idStudent);
            ResultSet rs = statement.executeQuery();
            rs.next();
            entity = getMarkExtend(rs);
            log.info("Find record in database.");
        } catch (SQLException e) {
            log.error("Error: ", e);
            e.printStackTrace();
        }
        return entity;
    }

    private String getQueryMark() {
        return "SELECT \n" +
                "    mark.idMark,\n" +
                "    mark.idCourse,\n" +
                "    mark.idStudent,\n" +
                "    course.Name AS NameCourse,\n" +
                "    student.Name AS NameStudent,\n" +
                "    student.SurName,\n" +
                "    student.Patronymic,\n" +
                "    mark.Comment\n" +
                "FROM\n" +
                "    mark\n" +
                "        JOIN\n" +
                "    course ON (mark.idCourse = course.idCourse\n" +
                "        AND course.idCourse = ?)\n" +
                "        JOIN\n" +
                "    student ON (mark.idStudent = student.Id\n" +
                "        AND student.Id = ?)";
    }

    private MarkExtend getMarkExtend(ResultSet rs) throws SQLException {
        MarkExtend markExtend = new MarkExtend();
        markExtend.setId(rs.getInt("idMark"));
        markExtend.setIdCourse(rs.getInt("idCourse"));
        markExtend.setIdStudent(rs.getInt("idStudent"));
        markExtend.setNameCourse(rs.getString("NameCourse"));
        String nameStudent = rs.getString("NameStudent") + " " + rs.getString("SurName") + " " + rs.getString("Patronymic");
        markExtend.setNameStudent(nameStudent);
        markExtend.setComment(rs.getString("Comment"));
        return markExtend;
    }
}
