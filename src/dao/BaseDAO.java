package dao;

import entity.IdEntity;

import java.util.List;

/**
 * Created by Anna on 12/1/2015.
 */
public interface BaseDAO<T extends IdEntity> {

    int insert(T entity) throws DAOException;

    boolean delete(int id) throws DAOException;

    T find(int id) throws DAOException;

    boolean update(T entity) throws DAOException;

    List<T> getAll() throws DAOException;
}
