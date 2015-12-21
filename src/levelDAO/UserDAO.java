package levelDAO;

import Entity.User;

/**
 * Created by Anna on 12/21/2015.
 */
public interface UserDAO extends BaseDAO<User> {
    User find(String login);

    User find(String login, String pwd);
}
