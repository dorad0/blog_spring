package blog.service.comment;

import blog.entity.Comment;
import blog.service.comment.web.CommentForm;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface CommentManager {
    List<Comment> getArticleComments(long articleId);

    void addComment(long articleId, CommentForm form, String username);
}
