package blog.service;

import blog.entity.Comment;
import blog.service.exception.ServiceException;
import blog.service.forms.CommentForm;

import java.util.List;

public interface CommentService extends GenericService<Comment, Long> {

    void addComment(long articleId, CommentForm form, String username) throws ServiceException;

    List<Comment> getArticleComments(Long articleId) throws ServiceException;

}
