package blog.dao;

import blog.entity.User;

public interface UserDAO extends GenericDAO<User, Long> {

    User findByName(String name);

}
