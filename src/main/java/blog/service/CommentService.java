package blog.service;

import blog.entity.Comment;
import blog.service.exception.ServiceException;
import blog.service.forms.CommentForm;

import java.util.List;

public interface CommentService extends GenericService<Comment, Long> {

    Long save(CommentForm form) throws ServiceException;

    List<Comment> getArticleComments(Long articleId) throws ServiceException;

    List<Comment> getUserComments(String userName) throws ServiceException;

}
