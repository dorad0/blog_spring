package blog.dao;


import blog.entity.User;
import org.springframework.stereotype.Repository;


/**
 * Created by user on 31.12.2014.
 */
@Repository(value = "UserDAOImpl")
public class UserDAOImpl extends GenericHibernateDAOImpl<User> implements UserDAO {

    @Override
    @SuppressWarnings("unchecked")
    public User findByName(String name) {
        return (User) getCurrentSession()
                .createQuery("FROM User WHERE name = :name")
                .setString("name", name).uniqueResult();
//        List<User> users = new ArrayList<User>();
//        users = sessionFactory.getCurrentSession()
//                .createQuery("from User where name=?")
//                .setParameter(0, username)
//                .list();
//
//        if (users.size() > 0) {
//            return users.get(0);
//        } else {
//            return null;
//        }
//    }
    }
}
