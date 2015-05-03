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


import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Aaron.setBirthDate(LocalDate.of(1993, 10, 10));
        Aaron.setEnabled(true);
        Aaron.setName("Aaron");
        Aaron.setPassword("123456");
        Aaron.setRegistrationDate(LocalDateTime.of(2015, 11, 11, 14, 0, 0));

        userDao.save(Aaron);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user/expected-data-update.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() {
        User user = userDao.findById(1L);
        user.setName("Aaron");
        user.setPassword("123456");
        userDao.update(user);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user/expected-data-delete.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() {
        User user = userDao.findById(1L);
//        User user = new User();
//        user.setId(1L);
        userDao.delete(user);

    }

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
        User oliver = userDao.findById(1L);
        User userTest = userDao.findByName("Oliver");

        assertEquals(oliver, userTest);
    }


    @Test
    @DatabaseSetup(value = "/blog/dao/user/data.xml")
    public void testFindById() {
        User user = userDao.findById(1L);

        assertEquals(1L, user.getId());
        assertEquals("Oliver", user.getName());
    }

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
