package blog.service;

import blog.model.User;
import blog.model.auth.Role;
import blog.service.form.UserForm;

/**
 * Created by user on 27.01.2015.
 */
public interface UserService {
    User getUser(String username);
    void save(UserForm userForm);
//    public void addRole(User user, Role role);
}
