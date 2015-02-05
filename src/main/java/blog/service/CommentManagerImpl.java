package blog.service;

import blog.dao.CommentDAO;
import blog.entity.Comment;
import org.springframework.stereotype.Service;

/**
 * Created by Alex on 05.02.2015.
 */
@Service
public class CommentManagerImpl extends GenericManagerImpl<Comment, CommentDAO> implements CommentManager {
}
