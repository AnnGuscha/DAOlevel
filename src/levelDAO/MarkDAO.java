package levelDAO;

import Entity.Mark;

/**
 * Created by Anna on 12/1/2015.
 */
public interface MarkDAO extends BaseDAO<Mark> {

    Mark find(int idCourse, int idStudent);

    boolean delete(Mark mark);
}