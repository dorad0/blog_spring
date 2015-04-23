package blog.dao.impl;

import blog.dao.UserRoleDAO;
import blog.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRoleDAOImpl")
public class UserRoleDAOImpl extends GenericHibernateDAOImpl<UserRole, Long> implements UserRoleDAO {

}
