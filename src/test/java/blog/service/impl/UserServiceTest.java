package blog.service.impl;

import blog.dao.UserDAO;
import blog.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by user_1 on 10/9/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetUserLoginTime() {
        when(userDAO.findByName("Test user")).thenReturn(new User());
        userService.setGenericDAO(userDAO);
        userService.setUserLoginTime("Test user");

        verify(userDAO, times(1)).save(new User());
        verify(userDAO, times(1)).findByName("Test user");

        verifyNoMoreInteractions(userDAO);
    }
}
