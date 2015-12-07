package levelDAO;

import levelMYSQL.MySQLCourseDAO;
import levelMYSQL.MySQLDAOFactory;
import levelMYSQL.MySQLListStudentsDAO;

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
                return new MySQLDAOFactory();
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

    public abstract MySQLCourseDAO getCourseDAO();

    public abstract MarkDAO getMarkDAO();

    public abstract MySQLListStudentsDAO getListStudentsDAO();
}
