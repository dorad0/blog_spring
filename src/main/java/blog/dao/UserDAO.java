package blog.dao;


import blog.model.User;
import blog.model.UserRole;

/**
 * Created by user on 31.12.2014.
 */
public interface UserDAO {
    void addUser(User user);

    void deleteUser(User user);

    User findByUserName(String username);
}
