package blog.service.impl;

import blog.dao.UserRoleDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends GenericServiceImpl<Long, UserRole, UserRoleDAO> implements UserRoleService {

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
