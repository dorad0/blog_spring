package blog.service.impl;

import blog.dao.ArticleDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTest {

    @Mock
    private ArticleDAO articleDAO;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDelete() {
        articleService.delete(anyLong());

        verify(articleDAO, times(1)).delete(anyLong());

        verifyNoMoreInteractions(articleDAO);
    }

}
