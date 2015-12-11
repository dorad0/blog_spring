package blog.dao.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.CommentDAO;
import blog.dao.exception.DaoException;
import blog.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl extends GenericHibernateDAOImpl<Comment, Long> implements CommentDAO {

    @ExceptionTranslation
    @Override
    public List<Comment> getArticleComments(Long articleId) {
        return getCurrentSession().createQuery("FROM Comment WHERE article_id = " + articleId + " ORDER BY publicationDate ASC").list();
    }

    @Override
    public List<Comment> getUserComments(String userName) throws DaoException {
        return getCurrentSession().createQuery("FROM Comment WHERE user_id IN(SELECT id FROM User where name = '" + userName + "') ORDER BY publicationDate DESC").list();
    }

}
