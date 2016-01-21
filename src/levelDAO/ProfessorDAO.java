package levelDAO;

import Entity.Professor;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ProfessorDAO extends BaseDAO<Professor> {
    Professor findByUserId(int userId);
}
