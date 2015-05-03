package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.CommentDAO;
import blog.entity.Article;
import blog.entity.Comment;
import blog.service.CommentService;
import blog.service.forms.CommentForm;
import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional
public class GenericService extends GenericServiceImpl<Long, Comment, CommentDAO> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    @Autowired
    protected void setDao(CommentDAO dao) {
        super.setDao(dao);
    }

    @ExceptionTranslation
    @Override
    public void addComment(long articleId, CommentForm form, String userName) {
        Comment comment = new Comment();
        comment.setText(form.getText());
        comment.setPublicationDate(LocalDateTime.now());
        comment.setUser(userService.findByName(userName));

        Article article = new Article();
        article.setId(articleId);
        comment.setArticle(article);
        dao.save(comment);
    }

    @ExceptionTranslation
    @Override
    public List<Comment> getArticleComments(Long articleId) {
        return dao.getArticleComments(articleId);
    }

}
