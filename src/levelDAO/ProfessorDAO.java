package levelDAO;

import Entity.Professor;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ProfessorDAO {

    int insertProfessor(Professor professor);
    boolean deleteProfessor(int id);
    Professor findProfessor(int id);
    boolean updateProfessor(Professor newProfessor);
    //public RowSet selectProfessorRS();
    //public Collection selectProfessorsTO();
}
