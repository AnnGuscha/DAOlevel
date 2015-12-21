package levelDAO;

import levelMYSQL.MySQLDAOFactory;

/**
 * Created by Anna on 12/1/2015.
 */
public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int CLOUDSCAPE = 2;
    public static final int ORACLE = 3;
    public static final int SYBASE = 4;

    public static DAOFactory getDAOFactory(int whichFactory)
    {
        switch (whichFactory)
        {
            case MYSQL:
                return MySQLDAOFactory.getMySqlFactory();
            case CLOUDSCAPE:
                //return new CloudscapeDAOFactory();
            case ORACLE:
                //return new OracleDAOFactory();
            case SYBASE:
                //return new SybaseDAOFactory();
            default:
                return null;
        }
    }

    public abstract StudentDAO getStudentDAO();

    public abstract ProfessorDAO getProfessorDAO();

    public abstract CourseDAO getCourseDAO();

    public abstract MarkDAO getMarkDAO();

    public abstract ListStudentsDAO getListStudentsDAO();

    public abstract ParticularQueriesDAO getParticularQueriesDAO();

    public abstract UserDAO getUserDAO();
}
