package levelDAO;

import levelMYSQL.*;

/**
 * Created by Anna on 12/1/2015.
 */
public abstract class DAOFactory {

    public static final int CLOUDSCAPE = 1;
    public static final int ORACLE = 2;
    public static final int SYBASE = 3;
    public static final int MYSQL = 4;

    public abstract StudentDAO getStudentDAO();
    public abstract ProfessorDAO getProfessorDAO();
    public abstract MySQLCourseDAO getCourseDAO();
    public abstract MarkDAO getMarkDAO();
    public abstract MySQLListStudentsDAO getListStudentsDAO();

    public static DAOFactory getDAOFactory(int whichFactory)
    {
        switch (whichFactory)
        {
            case CLOUDSCAPE:
                //return new CloudscapeDAOFactory();
            case ORACLE:
                //return new OracleDAOFactory();
            case SYBASE:
                //return new SybaseDAOFactory();
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
