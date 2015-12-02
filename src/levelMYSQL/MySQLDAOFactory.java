package levelMYSQL;

import Manager.ConnectionPool;
import levelDAO.DAOFactory;
import levelDAO.MarkDAO;
import levelDAO.ProfessorDAO;
import levelDAO.StudentDAO;
import org.apache.log4j.Logger;

/**
 * Created by Anna on 12/1/2015.
 */
public class MySQLDAOFactory extends DAOFactory {

    private static final Logger log = Logger.getLogger(MySQLDAOFactory.class);
    public static ConnectionPool pool;

	/*public static Connection createConnection()
	{
		Connection connection = null;
		try {
            pool=ConnectionPool.getConnectionPool(5);
            connection = pool.retrieve();
       } catch (SQLException e) {
    	   log.error("Error:", e);
            e.printStackTrace();
       }
		return connection;
	}*/

    public StudentDAO getStudentDAO()
    {
        return new MySQLStudentDAO();
    }

    public ProfessorDAO getProfessorDAO()
    {
        return new MySQLProfessorDAO();
    }

    public MySQLCourseDAO getCourseDAO()
    {
        return new MySQLCourseDAO();
    }

    public MarkDAO getMarkDAO()
    {
        return new MySQLMarkDAO();
    }

    public MySQLListStudentsDAO getListStudentsDAO()
    {
        return new MySQLListStudentsDAO();
    }
}
