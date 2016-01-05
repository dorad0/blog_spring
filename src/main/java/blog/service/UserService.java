package blog.service;

import blog.entity.Article;
import blog.entity.User;
import blog.service.exception.ServiceException;
import blog.service.forms.UserForm;
import blog.service.chart.models.NewData;

import java.util.List;

public interface UserService extends GenericService<User, Long> {

    User findByName(String name) throws ServiceException;

    Long saveUserFromForm(UserForm form) throws ServiceException;

    void setUserLoginTime(String userName) throws ServiceException;

    List<Article> findUserArticles(String userName) throws ServiceException;

    NewData getUsersRegisterData() throws  ServiceException;

}
