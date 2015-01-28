package blog.service;

import blog.dao.UserDAO;
import blog.model.User;
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
    private UserDAO dao;



    @Override
    @Transactional
    public User getUser(String username) {
        return dao.findByUserName(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setRegistrationDate(new Date());
        dao.addUser(user);
    }
}
