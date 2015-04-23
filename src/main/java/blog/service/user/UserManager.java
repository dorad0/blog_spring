package blog.service.user;

import blog.dao.UserDAO;
import blog.entity.User;
import blog.service.GenericManager;
import blog.service.user.web.UserForm;

/**
 * Created by Alex on 05.02.2015.
 */
public interface UserManager extends GenericManager<User, Long> {
    User findByName(String name);
    void saveUserFromForm(UserForm form);
}
