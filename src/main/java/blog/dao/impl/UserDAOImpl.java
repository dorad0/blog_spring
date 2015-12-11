package blog.dao.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.UserDAO;
import blog.dao.exception.DaoException;
import blog.entity.Article;
import blog.entity.User;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository(value = "UserDAOImpl")
public class UserDAOImpl extends GenericHibernateDAOImpl<User, Long> implements UserDAO {

    @ExceptionTranslation
    @Override
    public User findByName(String name) {
        return (User) getCurrentSession()
                .createQuery("FROM User WHERE name = :name")
                .setString("name", name).uniqueResult();
    }

    @ExceptionTranslation
    @Override
    public List<Article> getUserArticles(String userName) throws DaoException {

        return null;
    }

    @Override
    public List<Article> getUserArticles(Long userId) throws DaoException {
        return getCurrentSession().createQuery("FROM Article WHERE user_id = " + userId).list();
    }

}
