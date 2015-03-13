package blog.dao;

import blog.entity.UserRole;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 29.01.2015.
 */
@Repository(value = "UserRoleDAOImpl")
public class UserRoleDAOImpl extends GenericHibernateDAOImpl<UserRole> implements UserRoleDAO {

    @Override
    public void addRoleToUser(UserRole userRole) {
        sessionFactory.getCurrentSession().persist(userRole);
    }
}