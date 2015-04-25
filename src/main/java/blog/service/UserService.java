package blog.service;

import blog.entity.User;
import blog.service.forms.UserForm;

public interface UserService extends GenericService<User, Long> {

    User findByName(String name);

    void saveUserFromForm(UserForm form);

}
