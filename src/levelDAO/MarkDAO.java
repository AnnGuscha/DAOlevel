package levelDAO;

import Entity.Mark;

/**
 * Created by Anna on 12/1/2015.
 */
public interface MarkDAO {

    int insertMark(Mark mark);
    boolean deleteMark(int id);
    Mark findMark(int id);
    boolean updateMark(Mark newMark);
    //public RowSet selectMarkRS();
    //public Collection selectMarksTO();
}