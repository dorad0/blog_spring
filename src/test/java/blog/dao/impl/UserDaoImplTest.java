package blog.dao.impl;

import blog.dao.UserDAO;
import blog.entity.User;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by alex on 4/20/2015.
 */
@Transactional
public class UserDaoImplTest extends DaoTest {

    @Qualifier(value = "UserDAOImpl")
    @Autowired
    private UserDAO userDao;

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user/expected-data-save.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        User Aaron = new User();
        Aaron.setBirthDate(new GregorianCalendar(1993, 9, 10));
        Aaron.setEnabled(true);
        Aaron.setName("Aaron");
        Aaron.setPassword("123456");
        Aaron.setRegistrationDate(new GregorianCalendar(2015, 10, 11, 14, 0, 0));

        userDao.save(Aaron);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user/expected-data-update.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() {
//        User user = new User();
//        user.setId(1L);
//        user.setBirthDate(new GregorianCalendar(1993, 10, 10));
//        user.setEnabled(true);
//        user.setName("Aaron");
//        user.setPassword("123456");
//        user.setRegistrationDate(new GregorianCalendar(2015, 10, 11, 14, 0, 0));
//        user.setComments(null);

//        userDao.update(user);
    }

//    @Test
//    @DatabaseSetup(value = "/blog/dao/user/data.xml")
//    @ExpectedDatabase(value = "/blog/dao/user/expected-data-delete.xml",
//            assertionMode = DatabaseAssertionMode.NON_STRICT)
//    public void testDelete() {
//        User user = userDao.findById(1L);
//        userDao.delete(user);
//    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user/expected-data-delete.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDeleteById() {
        userDao.delete(1L);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    public void testFindByName() {
        User oliver = new User();
        oliver.setId(1L);
        oliver.setBirthDate(new GregorianCalendar(1993, 9, 10));
        oliver.setEnabled(true);
        oliver.setName("Oliver");
        oliver.setPassword("6543210");
        oliver.setRegistrationDate(new GregorianCalendar(2015, 04, 12, 14, 0, 0));

        User user = userDao.findByName("Oliver");

        assertEquals(oliver, user);
    }


//    @Test
//    @DatabaseSetup(value = "/blog/dao/user/data.xml")
//    public void testFindById() {
//        User oliver = new User();
//        oliver.setId(1L);
//        oliver.setBirthDate(new GregorianCalendar(1993, 9, 10));
//        oliver.setEnabled(true);
//        oliver.setName("Oliver");
//        oliver.setPassword("6543210");
//        oliver.setRegistrationDate(new GregorianCalendar(2015, 04, 12, 14, 0, 0));
//
//        User user = userDao.findById(1L);
//        assertEquals(oliver, user);
//
//    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    public void testFindAll() {
        List<User> users = userDao.findAll();
        assertEquals(2, users.size());
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    public void testGetCount() {
        Long count = userDao.getCount();
        assertEquals(Long.valueOf(2L), count);
    }

}
