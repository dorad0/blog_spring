package blog.service;

import blog.model.User;

/**
 * Created by user on 27.01.2015.
 */
public interface UserService {
    User getUser(String username);
    void save(User user);
}
