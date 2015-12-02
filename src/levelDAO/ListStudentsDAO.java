package levelDAO;

import Entity.ListStudents;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ListStudentsDAO {

    public int insertListStudents(ListStudents listStudents);
    public boolean deleteListStudents(int id);
    public ListStudents findListStudents(int id);
    public boolean updateListStudents(ListStudents newListStudent);
    //public RowSet selectListStudentsRS();
    //public Collection selectListsStudentsTO();
}
