package levelDAO;

import Entity.IdEntity;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface BaseDAO<T extends IdEntity> {

    int insert(T entity);
    boolean delete(int id);
    T find(int id);
    boolean update(T entity);
    List<T> getAll();
    //public RowSet selectProfessorRS();
    //public Collection selectProfessorsTO();
}