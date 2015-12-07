package levelMYSQL;

/**
 * Created by Anna on 12/1/2015.
 */

import Entity.Professor;
import levelDAO.ProfessorDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLProfessorDAO extends BaseDAOImpl<Professor> implements ProfessorDAO {

    private static final Logger log = Logger.getLogger(MySQLProfessorDAO.class);

    public MySQLProfessorDAO() {
    }

    @Override
    PreparedStatement fillStatementParams(Professor entity, PreparedStatement statement) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getFirstName());
        statement.setString(3, entity.getSurName());
        statement.setString(4, entity.getPatronymicName());
        return statement;
    }

    @Override
    String getTypeParam() {
        return "Professor";
    }

    @Override
    Professor getT(ResultSet rs) throws SQLException {
        return new Professor(rs.getInt("idProfessor"), rs.getString("Name"), rs.getString("SurName"), rs.getString("Patronymic"));
    }
}

