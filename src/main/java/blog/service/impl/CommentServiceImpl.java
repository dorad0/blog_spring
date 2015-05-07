package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.CommentDAO;
import blog.entity.Comment;
import blog.service.CommentService;
import blog.service.UserService;
import blog.service.forms.CommentForm;
import blog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl extends GenericServiceImpl<Long, Comment, CommentDAO> implements CommentService {

//    @Autowired
//    private UserService userService;

    @Autowired
    private Converter converter;

    @Override
    @Autowired
    protected void setGenericDAO(CommentDAO genericDAO) {
        super.setGenericDAO(genericDAO);
    }

    @ExceptionTranslation
    @Override
    public Long save(CommentForm commentForm) {
        Comment comment = converter.convertCommentFormToComment(commentForm);
        comment.setPublicationDate(LocalDateTime.now());

        return genericDAO.save(comment);
    }

    @ExceptionTranslation
    @Override
    public List<Comment> getArticleComments(Long articleId) {
        return genericDAO.getArticleComments(articleId);
    }

}
