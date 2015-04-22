package blog.service.comment;

import blog.dao.CommentDAO;
import blog.entity.Comment;
import blog.service.GenericManager;
import blog.service.comment.web.CommentForm;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface CommentManager extends GenericManager<Comment>{
    void addComment(long articleId, CommentForm form, String username);

    List<Comment> getArticleComments(Long articleId);
}
