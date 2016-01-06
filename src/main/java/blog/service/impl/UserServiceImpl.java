package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.UserDAO;
import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import blog.entity.UserRole;
import blog.service.CommentService;
import blog.service.UserRoleService;
import blog.service.UserService;
import blog.service.chart.models.ChartData;
import blog.service.exception.ServiceException;
import blog.service.forms.UserForm;
import blog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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

    @Autowired
    private CommentService commentService;

    @ExceptionTranslation
    @Override
    public Long saveUserFromForm(UserForm userForm) {
        User user = converter.convertUserFormToUser(userForm);

        String encodedPassword = encoder.encode(user.getPassword());

        user.setRegistrationDate(LocalDateTime.now());
//        user.setLastVisit(LocalDateTime.now());
        user.setPassword(encodedPassword);
        // user.setBirthDate(user.getBirthDate());
        user.setEnabled(true);

        Long userId = save(user);

        UserRole role = new UserRole(user, "ROLE_USER");

        roleManager.save(role);

        return userId;
    }

    @Override
    public void setUserLoginTime(String userName) throws ServiceException {
        User loginUser = findByName(userName);
//        loginUser.setLastVisit(LocalDateTime.now());
        save(loginUser);
    }

    @ExceptionTranslation
    @Override
    public List<Article> findUserArticles(String userName) throws ServiceException {
        List<Article> articles = new ArrayList<>();
        User user = genericDAO.findByName(userName);

        if (user != null) {
            articles = genericDAO.getUserArticles(user.getId());
        }

        return articles;
    }

    @ExceptionTranslation
    @Override
    public User findByName(String name) {
        return genericDAO.findByName(name);
    }

    class Point <T> {
        T data;
        int number;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    @ExceptionTranslation
    @Override
    public ChartData getUsersRegisterData() throws ServiceException {


        List<User> users = genericDAO.findAll();
        List<Point<LocalDate>> points = new ArrayList<>();
        Set<LocalDate> dates = new HashSet<>();

        for (User user : users) {
            dates.add(user.getRegistrationDate().toLocalDate());
        }

        for (LocalDate date : dates) {
            Point point = new Point();
            point.setData(date);

            points.add(point);
        }

        for (User user : users) {
            for (Point<LocalDate> point : points) {
                if (user.getRegistrationDate().toLocalDate().isEqual(point.data)) {
                    point.setNumber(point.getNumber() + 1);
                }
            }
        }

        List<String> labels = new ArrayList<>();
        List<String> data = new ArrayList<>();
        points.sort((o1, o2) -> o1.getData().compareTo(o2.getData()));
        for (Point point : points) {
            labels.add(point.getData().toString());
            data.add(Integer.toString(point.getNumber()));
        }

        ChartData returnData = new ChartData();
        returnData.setLabels(labels);
        returnData.setData(data);


        return returnData;
    }

    @ExceptionTranslation
    @Override
    public ChartData getCommentsActivity() throws ServiceException {

        List<Comment> comments = commentService.findAll();

        ChartData returnData = new ChartData();
        Set<LocalDate> dates = new HashSet<>();
        List<String> data = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Point<LocalDate>> points = new ArrayList<>();

        for (Comment comment : comments) {
            dates.add(comment.getPublicationDate().toLocalDate());
        }


        for (LocalDate date : dates) {
            Point point = new Point();
            point.setData(date);
            points.add(point);
        }

        for (Comment comment : comments) {
            for (Point<LocalDate> point : points) {
                if (point.getData().isEqual(comment.getPublicationDate().toLocalDate())) {
                    point.setNumber(point.getNumber() + 1);
                }
            }
        }

        points.sort((o1, o2) -> o1.getData().compareTo(o2.getData()));

        for (Point point : points) {
            labels.add(point.getData().toString());
            data.add(Integer.toString(point.getNumber()));
        }

        returnData.setLabels(labels);
        returnData.setData(data);

        return returnData;
    }

    @ExceptionTranslation
    @Override
    public ChartData getUsersComment() throws ServiceException {
        List<Comment> comments = commentService.findAll();
        Set<String> usersName = new HashSet<>();
        List<Point<String>> points = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<String> data = new ArrayList<>();
        ChartData chartData = new ChartData();

        for (Comment comment : comments) {
            usersName.add(comment.getUser().getName());
        }

        for (String name : usersName) {
            Point point = new Point();
            point.setData(name);
            points.add(point);
        }

        for (Comment comment : comments) {
            for (Point<String> point : points) {
                if (point.getData().compareTo(comment.getUser().getName()) == 0) {
                    point.setNumber(point.getNumber() + 1);
                }
            }
        }



        for (Point<String> point : points) {
            labels.add(point.getData());
            data.add(Integer.toString(point.getNumber()));
        }

        chartData.setData(data);
        chartData.setLabels(labels);

        return chartData;
    }
}
