package blog.service;

import blog.entity.User;
import blog.entity.UserRole;

public interface UserRoleService extends GenericService<UserRole, Long> {

    void addRoleToUser(User user, String role);

}
