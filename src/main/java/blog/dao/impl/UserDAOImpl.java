package blog.dao.impl;

import blog.dao.UserDAO;
import blog.entity.User;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDAOImpl")
public class UserDAOImpl extends GenericHibernateDAOImpl<User, Long> implements UserDAO {

    @Override
    public User findByName(String name) {
        return (User) getCurrentSession()
                .createQuery("FROM User WHERE name = :name")
                .setString("name", name).uniqueResult();
    }

}
