package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.UserDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.UserRoleService;
import blog.service.UserService;
import blog.service.exception.ServiceException;
import blog.service.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<Long, User, UserDAO> implements UserService {

    @Override
    @Autowired
    @Qualifier("UserDAOImpl")
    protected void setDao(UserDAO dao) {
        super.setDao(dao);
    }

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRoleService roleManager;

    @ExceptionTranslation
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

    @ExceptionTranslation
    @Override
    public User findByName(String name) {
        return dao.findByName(name);
    }

}
