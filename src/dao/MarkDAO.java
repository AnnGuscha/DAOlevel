package dao;

import entity.Mark;

/**
 * Created by Anna on 12/1/2015.
 */
public interface MarkDAO extends BaseDAO<Mark> {

    Mark find(int idCourse, int idStudent) throws DAOException;

    boolean delete(Mark mark) throws DAOException;
}