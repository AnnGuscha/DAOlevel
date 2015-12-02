package levelDAO;

import Entity.Professor;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ProfessorDAO {

    public int insertProfessor(Professor professor);
    public boolean deleteProfessor(int id);
    public Professor findProfessor(int id);
    public boolean updateProfessor(Professor newProfessor);
    //public RowSet selectProfessorRS();
    //public Collection selectProfessorsTO();
}
