package blog.dao.impl;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by alex on 5/1/2015.
 */
@Transactional
public class ArticleDaoImplTest extends DaoTest {

    @Autowired
    ArticleDAO articleDAO;

    public void testGetComments() {
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
}
