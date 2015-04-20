package blog.dao.impl;

import blog.TestAppConfig;
import blog.dao.UserDAO;
import blog.entity.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by alex on 4/20/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestAppConfig.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public  class DaoTest {

    @Qualifier(value="UserDAOImpl")
    @Autowired
    private UserDAO userDao;

    @Test
    @DatabaseSetup(value="/data.xml")
    @ExpectedDatabase(value="/expected-data-save.xml",
            assertionMode= DatabaseAssertionMode.NON_STRICT)
    public void testSave() {
        User user = new User();
        user.setName("test_name");

        //userDao.save(user);
    }
}
