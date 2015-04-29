package blog.dao;

import blog.dao.exception.DaoException;
import blog.entity.User;

public interface UserDAO extends GenericDAO<User, Long> {

    User findByName(String name) throws DaoException;

}
