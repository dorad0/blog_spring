package blog.dao;

import blog.model.User;
import blog.model.UserRole;

import java.util.List;

/**
 * Created by user on 29.01.2015.
 */
public interface UserRoleDAO {

    void addRoleToUser(UserRole userRole);
}
