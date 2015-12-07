package Entity;

import levelDAO.DAOFactory;
import levelDAO.ProfessorDAO;
import levelDAO.StudentDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Anna on 12/1/2015.
 */
public class Elective implements java.io.Serializable {

    private static final Logger log = Logger.getLogger(Elective.class);

    public static void main(String[] args) {

        //String log4jConfigFile =System.getProperty("user.dir")+ File.separator +  "src\\log4j.properties";
        String log4jConfigFile = "src\\log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        DAOFactory MySQLFactory =
                DAOFactory.getDAOFactory(DAOFactory.MYSQL);

        StudentDAO stDAO =
                MySQLFactory.getStudentDAO();
        Student newStudent = new Student(15,"Anna","Guscha","Victorovna");
        stDAO.insert(newStudent);

        ProfessorDAO profDAO =
                MySQLFactory.getProfessorDAO();

        Professor cust = profDAO.find(1);

        System.out.println(cust.toString());
    }
}
