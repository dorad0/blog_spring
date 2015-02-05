package blog.service;

import blog.dao.UserDAO;
import blog.dao.UserRoleDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;

/**
 * Created by Alex on 05.02.2015.
 */
@Service
@Transactional
public class UserManagerImpl extends GenericManagerImpl<User, UserDAO> implements UserManager {


    @Override
    @Autowired
    @Qualifier("UserDAOImpl")
    protected void setDao(UserDAO dao) {
        super.setDao(dao);
    }

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRoleDAO roleDAO;

    @Override
    public void saveUserFromForm(UserForm form) {
        User user = new User();
        user.setRegistrationDate(GregorianCalendar.getInstance());
        user.setName(form.getName());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setBirthDate(form.getBirthDate());
//        user.setEnabled(true);
//        userDAO.addUser(user);
        super.save(user);
        UserRole role = new UserRole(user, "ROLE_USER");
        roleDAO.addRoleToUser(role);
    }

    @Override
    public User findByName(String name) {
        return dao.findByName(name);
    }
}
