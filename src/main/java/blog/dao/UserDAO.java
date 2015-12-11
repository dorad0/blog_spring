package blog.dao;

import blog.dao.exception.DaoException;
import blog.entity.Article;
import blog.entity.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    User findByName(String name) throws DaoException;

    List<Article> getUserArticles(String userName) throws DaoException;

    List<Article> getUserArticles(Long userId) throws DaoException;
}
