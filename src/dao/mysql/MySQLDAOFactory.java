package dao.mysql;

import dao.*;
import manager.ConnectionPool;
import org.apache.log4j.Logger;

/**
 * Created by Anna on 12/1/2015.
 */
public class MySQLDAOFactory extends DAOFactory {

    private static final Logger log = Logger.getLogger(MySQLDAOFactory.class);
    public static ConnectionPool pool;

    private static MySQLDAOFactory mySQLDAOFactory = new MySQLDAOFactory();

    private MySQLDAOFactory() {
    }

    public static MySQLDAOFactory getMySqlFactory() {
        return mySQLDAOFactory;
    }

    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }

    public ProfessorDAO getProfessorDAO() {
        return new MySQLProfessorDAO();
    }

    public CourseDAO getCourseDAO() {
        return new MySQLCourseDAO();
    }

    public MarkDAO getMarkDAO() {
        return new MySQLMarkDAO();
    }

    public ListStudentsDAO getListStudentsDAO() {
        return new MySQLListStudentsDAO();
    }

    public ParticularQueriesDAO getParticularQueriesDAO() {
        return new MySQLParticularQueriesDAO();
    }

    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }
}

