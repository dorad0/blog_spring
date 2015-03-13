package blog.service.user;

import blog.dao.UserDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.GenericManagerImpl;
import blog.service.roles.UserRoleManager;
import blog.service.user.web.UserForm;
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
    private UserRoleManager roleManager;

    @Override
    public void saveUserFromForm(UserForm form) {
        User user = new User();
        user.setRegistrationDate(GregorianCalendar.getInstance());
        user.setName(form.getName());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setBirthDate(form.getBirthDate());
        user.setEnabled(true);
        save(user);
        UserRole role = new UserRole(user, "ROLE_USER");
        roleManager.save(role);
    }

    @Override
    public void deleteUserById(long id) {
        User user = findById(id);
        delete(user);
    }

    @Override
    public User findByName(String name) {
        return dao.findByName(name);
    }
}
