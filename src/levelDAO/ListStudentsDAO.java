package levelDAO;

import Entity.ListStudents;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ListStudentsDAO {

    int insertListStudents(ListStudents listStudents);
    boolean deleteListStudents(int id);
    ListStudents findListStudents(int id);
    boolean updateListStudents(ListStudents newListStudent);
    //public RowSet selectListStudentsRS();
    //public Collection selectListsStudentsTO();
}
