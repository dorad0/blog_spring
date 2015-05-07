package blog.dao.impl;

import blog.dao.UserDAO;
import blog.dao.UserRoleDAO;
import blog.entity.User;
import blog.entity.UserRole;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public class UserRoleDaoImplTest extends DaoTest {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @DatabaseSetup(value = "/blog/dao/user_role/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user_role/expected-data-save.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_ADMIN");
        User user = userDAO.findById(1L);
        userRole.setUser(user);

        userRoleDAO.save(userRole);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/user_role/data.xml")
    @ExpectedDatabase(value = "/blog/dao/user_role/expected-data-update.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() {
        UserRole userRole = userRoleDAO.findById(1L);
        userRole.setRole("ROLE_ADMIN");

        userRoleDAO.update(userRole);
    }

//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    @ExpectedDatabase(value = "/blog/genericDAO/user_role/expected-data-delete.xml",
//            assertionMode = DatabaseAssertionMode.NON_STRICT)
//    public void testDelete() {
//        User user = userDao.findById(1L);
////        User user = new User();
////        user.setId(1L);
//        userDao.delete(user);
//
//    }
//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    @ExpectedDatabase(value = "/blog/genericDAO/user_role/expected-data-delete.xml",
//            assertionMode = DatabaseAssertionMode.NON_STRICT)
//    public void testDeleteById() {
//        userDao.delete(1L);
//    }
//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    public void testFindByName() {
//        User oliver = userDao.findById(1L);
//        User userTest = userDao.findByName("Oliver");
//
//        assertEquals(oliver, userTest);
//    }
//
//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    public void testFindById() {
//        User user = userDao.findById(1L);
//
//        assertEquals(1L, user.getId());
//        assertEquals("Oliver", user.getName());
//    }
//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    public void testFindAll() {
//        List<User> users = userDao.findAll();
//
//        assertEquals(2, users.size());
//    }
//
//    @Test
//    @DatabaseSetup(value = "/blog/genericDAO/user_role/data.xml")
//    public void testGetCount() {
//        Long count = userDao.getCount();
//
//        assertEquals(Long.valueOf(2L), count);
//    }
}
