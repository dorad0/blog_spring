package blog.dao;

import blog.entity.Comment;

import java.util.List;

/**
 * Created by user on 19.12.2014.
 */
public interface CommentDAO extends GenericDAO<Comment, Long> {
    List<Comment> getArticleComments(Long articleId);
}
