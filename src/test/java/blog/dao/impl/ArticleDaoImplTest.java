package blog.dao.impl;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.entity.Comment;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;


/**
 * Created by alex on 5/1/2015.
 */
@Transactional
public class ArticleDaoImplTest extends DaoTest {

    @Autowired
    ArticleDAO articleDAO;

    @Test
    @DatabaseSetup(value = "/blog/dao/article/data.xml")
    public void testGetComments() {
        Set<Comment> articleComments = articleDAO.getComments(1L);
        assertEquals(2, articleComments.size());

    }

    public void testGetDates() {
    }

    public void testFindByMonthAndYear() {
    }

    public void testGetInitializedArticleById() {
    }


    @Test
    @DatabaseSetup(value = "/blog/dao/article/data.xml")
    public void testGetCount() {
        LocalDate date = LocalDate.of(2014, 1, 1);
        Long count = articleDAO.getCount(date);

        assertEquals(4L, count.longValue());
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/article/data.xml")
    public void testFindAll() {
        LocalDate date = LocalDate.of(2014, 1, 1);
        List<Article> list= articleDAO.findAll(1, 2, date);

        assertEquals(2, list.size());
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/article/data.xml")
    @ExpectedDatabase(value = "/blog/dao/article/expected-data-delete.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void delete() {
        Article articleToDelete = articleDAO.findById(1L);
        articleDAO.delete(articleToDelete);
    }

    @Test
    @DatabaseSetup(value = "/blog/dao/article/data.xml")
    @ExpectedDatabase(value = "/blog/dao/article/expected-data-delete.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void deleteById() {
        articleDAO.delete(1L);
    }
}
