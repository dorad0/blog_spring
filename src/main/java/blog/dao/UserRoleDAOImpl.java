package blog.dao;

import blog.entity.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 29.01.2015.
 */
@Repository
public class UserRoleDAOImpl extends AbstractHibernateDao<UserRole> implements UserRoleDAO {

    @Override
    public void addRoleToUser(UserRole userRole) {
        sessionFactory.getCurrentSession().persist(userRole);
    }
}
