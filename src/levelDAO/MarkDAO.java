package levelDAO;

import Entity.Mark;

/**
 * Created by Anna on 12/1/2015.
 */
public interface MarkDAO {

    public int insertMark(Mark mark);
    public boolean deleteMark(int id);
    public Mark findMark(int id);
    public boolean updateMark(Mark newMark);
    //public RowSet selectMarkRS();
    //public Collection selectMarksTO();
}