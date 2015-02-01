package blog.dao;

import blog.model.User;
import blog.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 29.01.2015.
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRoleToUser(UserRole userRole) {
        sessionFactory.getCurrentSession().persist(userRole);
    }
}
