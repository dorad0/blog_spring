package blog.service;

import blog.entity.Comment;
import blog.service.forms.CommentForm;

import java.util.List;

public interface CommentService extends GenericService<Comment, Long> {

    void addComment(long articleId, CommentForm form, String username);

    List<Comment> getArticleComments(Long articleId);

}
