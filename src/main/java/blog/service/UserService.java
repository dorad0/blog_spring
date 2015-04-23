package blog.service;

import blog.entity.User;
import blog.service.forms.UserForm;

/**
 * Created by Alex on 05.02.2015.
 */
public interface UserService extends GenericService<User, Long> {

    User findByName(String name);

    void saveUserFromForm(UserForm form);

}
