package blog.service.roles;

import blog.dao.UserRoleDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.GenericManager;

/**
 * Created by Alex on 06.02.2015.
 */
public interface UserRoleManager extends GenericManager<UserRole> {
    void addRoleToUser(User user, String role);
}