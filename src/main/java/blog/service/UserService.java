package blog.service;

import blog.entity.User;
import blog.service.exception.ServiceException;
import blog.service.forms.UserForm;

public interface UserService extends GenericService<User, Long> {

    User findByName(String name) throws ServiceException;

    void saveUserFromForm(UserForm form) throws ServiceException;

}
