package blog.dao;

import blog.dao.exception.DaoException;
import blog.entity.Comment;

import java.util.List;

public interface CommentDAO extends GenericDAO<Comment, Long> {

    List<Comment> getArticleComments(Long articleId) throws DaoException;

    List<Comment> getUserComments(String userName) throws DaoException;

}
