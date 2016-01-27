package dao;

import entity.ListStudents;

/**
 * Created by Anna on 12/1/2015.
 */
public interface ListStudentsDAO extends BaseDAO<ListStudents>{

    boolean delete(ListStudents listStudents);
}
