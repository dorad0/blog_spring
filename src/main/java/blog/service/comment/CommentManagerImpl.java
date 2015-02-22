package blog.service.comment;

import blog.dao.ArticleDAO;
import blog.dao.CommentDAO;
import blog.dao.UserDAO;
import blog.entity.Comment;
import blog.service.GenericManagerImpl;
import blog.service.article.ArticleManager;
import blog.service.comment.web.CommentForm;
import blog.service.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
@Service
@Transactional
public class CommentManagerImpl extends GenericManagerImpl<Comment, CommentDAO> implements CommentManager {

    @Autowired
    private UserManager userManager;

    @Autowired
    private ArticleManager articleManager;

    @Override
    @Autowired
    protected void setDao( CommentDAO dao) {
        super.setDao(dao);
    }

    @Override
    public List<Comment> getArticleComments(long articleId) {
        return dao.getArticleComments(articleId);
    }

    @Override
    public void addComment(long articleId, CommentForm form, String userName) {
        Comment comment = new Comment();
        comment.setText(form.getText());
        comment.setPublicationDate(new GregorianCalendar());
        comment.setUser(userManager.findByName(userName));
        comment.setArticle(articleManager.findById(articleId));
        dao.save(comment);
    }
}
