package blog.service;

import blog.dao.UserDAO;
import blog.dao.UserRoleDAO;
import blog.model.User;
import blog.model.UserRole;
import blog.service.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by user on 27.01.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO roleDAO;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public User getUser(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    @Transactional
    public void save(UserForm form) {

        User user = new User();
        user.setRegistrationDate(new Date());
        user.setName(form.getName());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setBirthDate(form.getBirthDate());
        user.setEnabled(true);
        userDAO.addUser(user);

        UserRole role = new UserRole(user, "ROLE_USER");
        roleDAO.addRoleToUser(role);
    }

//    @Override
//    @Transactional
//    public void addRole(User user, Role role) {
//        UserRole userRole = new UserRole(user, role);
//        roleDAO.addRoleToUser(userRole);
//    }
}
