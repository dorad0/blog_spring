package blog.dao;

import blog.entity.User;

/**
 * Created by user on 31.12.2014.
 */
public interface UserDAO extends GenericDAO<User> {
    User findByName(String name);
}
