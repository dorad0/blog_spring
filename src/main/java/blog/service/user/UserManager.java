package blog.service.user;

import blog.dao.UserDAO;
import blog.service.user.web.UserForm;

/**
 * Created by Alex on 05.02.2015.
 */
public interface UserManager extends UserDAO {
    public void saveUserFromForm(UserForm form);
}
