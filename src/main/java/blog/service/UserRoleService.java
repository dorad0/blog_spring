package blog.service;

import blog.entity.User;
import blog.entity.UserRole;

/**
 * Created by Alex on 06.02.2015.
 */
public interface UserRoleService extends GenericService<UserRole, Long> {

    void addRoleToUser(User user, String role);

}
