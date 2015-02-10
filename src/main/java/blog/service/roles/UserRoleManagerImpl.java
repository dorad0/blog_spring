package blog.service.roles;

import blog.dao.UserRoleDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alex on 06.02.2015.
 */
@Service
public class UserRoleManagerImpl extends GenericManagerImpl<UserRole, UserRoleDAO> implements UserRoleManager {

    @Override
    @Autowired
    protected void setDao(UserRoleDAO dao) {
        super.setDao(dao);
    }

    @Override
    public void addRoleToUser(User user, String role) {
        save(new UserRole(user, role));
    }
}
