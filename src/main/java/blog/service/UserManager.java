package blog.service;

import blog.dao.UserDAO;
import blog.service.form.UserForm;

/**
 * Created by Alex on 05.02.2015.
 */
public interface UserManager extends UserDAO {
    public void saveUserFromForm(UserForm form);
}
