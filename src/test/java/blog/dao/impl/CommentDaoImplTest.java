package blog.dao.impl;

import blog.dao.CommentDAO;
import blog.entity.Comment;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@Transactional
public class CommentDaoImplTest extends DaoTest {

    @Autowired
    private CommentDAO commentDAO;

    @Test
    @DatabaseSetup(value = "/blog/dao/comment/data.xml")
    @ExpectedDatabase(value = "/blog/dao/comment/expected-data-getArticleComments.xml")
    public void testGetArticleComments() {
        List<Comment> list1 = commentDAO.getArticleComments(1L);
        assertEquals(1, list1.size());

        List<Comment> list2 = commentDAO.getArticleComments(2L);
        assertEquals(2, list2.size());

        List<Comment> list3 = commentDAO.getArticleComments(3L);
        assertEquals(3, list3.size());

        List<Comment> list4 = commentDAO.getArticleComments(4L);
        assertEquals(1, list4.size());
    }
}
