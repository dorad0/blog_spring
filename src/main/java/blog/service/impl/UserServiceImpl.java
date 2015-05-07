package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.UserDAO;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.UserRoleService;
import blog.service.UserService;
import blog.service.forms.UserForm;
import blog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<Long, User, UserDAO> implements UserService {

    @Override
    @Autowired
    @Qualifier("UserDAOImpl")
    protected void setGenericDAO(UserDAO genericDAO) {
        super.setGenericDAO(genericDAO);
    }

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRoleService roleManager;

    @Autowired
    private Converter converter;

    @ExceptionTranslation
    @Override
    public Long saveUserFromForm(UserForm userForm) {
        User user = converter.convertUserFormToUser(userForm);

        String encodedPassword = encoder.encode(user.getPassword());

        user.setRegistrationDate(LocalDateTime.now());
        user.setPassword(encodedPassword);
        user.setBirthDate(LocalDate.now());
        user.setEnabled(true);

        Long userId = save(user);

        UserRole role = new UserRole(user, "ROLE_USER");

        roleManager.save(role);

        return userId;
    }

    @ExceptionTranslation
    @Override
    public User findByName(String name) {
        return genericDAO.findByName(name);
    }

}
